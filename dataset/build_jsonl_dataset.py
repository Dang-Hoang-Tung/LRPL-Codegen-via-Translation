import os
import re
import json

base_dir = "fn-signatures"
output_file = "kstack-clean-eval.jsonl"

fn_name_pattern = re.compile(
    r'fun\s+(?:<[^>]+>\s*)?(?:[\w$.<>]+\s*\.\s*)?(?P<name>`?[\w-]+`?)\s*\('
)

# === Extraction functions ===

def extract_id(filename):
    return filename[:-len("_fn_signature.kt")]

def extract_language():
    return "kotlin"

def extract_fn_signature(file_path):
    return read_file(file_path)

def extract_fn_name(fn_signature):
    match = fn_name_pattern.search(fn_signature or "")
    if not match:
        return None
    name = match.group("name")
    if name.startswith("`") and name.endswith("`"):
        name = name[1:-1]
    return name

def extract_context(file_id):
    path = os.path.join("context-masked", f"{file_id}_masked.kt")
    return read_file(path)

def extract_test(file_id):
    path = os.path.join("tests-adapted", f"{file_id}_test_adapted.kt")
    return read_file(path)

def extract_description(file_id, fn_signature):
    path = os.path.join("fn-descriptions", f"{file_id}_description.kt")
    desc = read_file(path)
    if desc is None:
        return None
    if fn_signature:
        desc = desc.replace(fn_signature, "")
    return desc.strip()

def extract_canonical_solution(file_id):
    path = os.path.join("canonical-solutions", f"{file_id}_solution.kt")
    return read_file(path)

def read_file(path):
    try:
        with open(path, "r", encoding="utf-8") as f:
            return f.read().strip()
    except FileNotFoundError:
        return None

# === Validation ===

def validate_record(record):
    for key, value in record.items():
        if key == "prompt":  # prompt can be empty
            continue
        if value is None or (isinstance(value, str) and value.strip() == ""):
            raise ValueError(f"Empty field '{key}' in task {record['task_id']}")

# === Main ===

with open(output_file, "w", encoding="utf-8") as out:
    for filename in os.listdir(base_dir):
        if filename.endswith("_fn_signature.kt"):
            file_path = os.path.join(base_dir, filename)
            file_id = extract_id(filename)
            fn_signature = extract_fn_signature(file_path)
            fn_name = extract_fn_name(fn_signature)

            record = {
                "task_id": file_id,
                "prompt": "<Construct prompt based on other fields>",
                "language": extract_language(),
                "entry_point": fn_name,
                "fn_name": fn_name,
                "fn_signature": fn_signature,
                "context": extract_context(file_id),
                "test": extract_test(file_id),
                "description": extract_description(file_id, fn_signature),
                "canonical_solution": extract_canonical_solution(file_id)
            }

            validate_record(record)

            json.dump(record, out, ensure_ascii=False)
            out.write("\n")

print(f"✅ JSONL written to {output_file}")

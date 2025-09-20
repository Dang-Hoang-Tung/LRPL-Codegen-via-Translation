import subprocess
import os
import sys
import shutil

def run_kotlin_sample(file_id):
    runner_file = "_temp_TestRunner.kt"
    out_dir = "_temp_out"

    try:
        # Open the adapted files using the provided file_id
        with open(f"context-adapted/{file_id}_adapted.kt", "r") as file1, \
             open(f"tests-adapted/{file_id}_test_adapted.kt", "r") as file2:
            adapted_content = file1.read()
            test_gen_content = file2.read()
    except FileNotFoundError:
        print(f"Error: Could not find adapted Kotlin files for ID {file_id}")
        # Perform cleanup even in case of an early exit
        cleanup(runner_file, out_dir)
        return

    print(f"Running Kotlin code file {file_id}...")
    full_kt = f"""
{adapted_content}

{test_gen_content}
"""
    with open(runner_file, "w") as f:
        f.write(full_kt)

    # Compile to local ./out directory
    os.makedirs(out_dir, exist_ok=True)
    compile_result = subprocess.run(
        ["kotlinc", runner_file, "-d", out_dir],
        capture_output=True, text=True
    )
    if compile_result.returncode != 0:
        print("Compilation errors:")
        print(compile_result.stderr)
    else:
        # Run the compiled class
        run_result = subprocess.run(
            ["kotlin", "-cp", out_dir, "TestRunnerKt"],
            capture_output=True, text=True
        )
        print("Output:")
        print(run_result.stdout)
        if run_result.stderr:
            print("Errors:\n", run_result.stderr)

    # Clean up generated files and directories
    cleanup(runner_file, out_dir)
    print("Sample checked successful.")

def cleanup(runner_file, out_dir):
    """Removes temporary files and directories."""
    if os.path.exists(runner_file):
        try:
            os.remove(runner_file)
        except OSError as e:
            print(f"Error: Could not remove '{runner_file}'. {e}")

    if os.path.exists(out_dir):
        try:
            shutil.rmtree(out_dir)
        except OSError as e:
            print(f"Error: Could not remove '{out_dir}' directory. {e}")

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python check_sample.py <file_id>")
        sys.exit(1)
        
    file_id = sys.argv[1]
    run_kotlin_sample(file_id)

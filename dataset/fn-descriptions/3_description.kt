/**
 * Evaluates a mathematical expression string with optional precedence rules.
 *
 * Recursively resolves expressions by first identifying innermost parentheses (no nesting),
 * replacing them with their computed result, and re-evaluating until no parentheses remain.
 * Once flattened, the expression is reduced step by step using either normal left-to-right
 * evaluation or with addition prioritized over multiplication depending on the flag.
 *
 * @param expression the input string representing a mathematical expression containing digits,
 *                  operators (+, *), and optional parentheses.
 * @param prioritizeAddition if true, addition operations are evaluated before multiplication;
 *                  otherwise expressions are evaluated strictly left-to-right.
 * @return the computed result of the expression as a Long value.
 */
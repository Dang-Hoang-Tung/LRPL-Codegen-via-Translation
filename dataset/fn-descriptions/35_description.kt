/**
 * Recursively constructs valid ring configurations by selecting the next internal node
 * and calculating its corresponding external node, while pruning duplicate searches.
 *
 * For each recursive step, the function:
 * - Determines the required external node based on the current ring node and the target sum [s].
 * - Validates that the external node is distinct, available, and ensures the smallest external
 *   node starts the sequence to avoid symmetric duplicates.
 * - Builds two mirrored solutions (original and reversed) when a valid ring is completed,
 *   exploiting the fact that solutions exist in pairs.
 * - Uses backtracking to restore removed digits and explore alternative branches.
 *
 * @param i The index of the current internal ring node being assigned.
 * @return Unit (results are collected in the enclosing [solutions] list).
 */
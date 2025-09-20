/**
 * Rearranges a binary search tree into an increasing order right-skewed tree using recursion.
 *
 * Performs an in-order traversal: processes the left subtree, then the current node, then the right subtree.
 * At each step, appends the current node's value to the rightmost position of the accumulating tree,
 * effectively flattening the BST into a chain of nodes where each node has only a right child.
 *
 * @param input the current subtree root being traversed; null indicates the end of a branch.
 * @param acc the partially built right-skewed tree that accumulates results across recursive calls.
 * @return the root of the increasing order right-skewed tree containing all values of the original BST.
 */
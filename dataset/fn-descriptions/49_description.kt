/**
 * Performs a topological sort on a directed graph of size `k`.
 *
 * Builds a graph from dependency pairs in `matrix`, computes in-degrees,
 * and applies BFS (Kahn's algorithm) to generate a valid topological order.
 * If a cycle exists, the resulting list will have fewer than `k` elements.
 *
 * @param k the number of nodes in the graph, labeled from 1 to k.
 * @param matrix an array of edges where each element is a pair [from, to],
 *               representing a directed edge from `from` to `to`.
 * @return a list of nodes in topologically sorted order; may be shorter than k if cycles are present.
 */
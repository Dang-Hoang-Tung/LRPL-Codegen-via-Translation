/**
 * Computes the minimum total cost to connect all islands with bridges.
 *
 * Uses Kruskal’s algorithm with Union-Find to build a Minimum Spanning Tree (MST).
 * The edges (bridges) are sorted by construction cost, and added one by one if
 * they do not form a cycle. The process stops once enough edges are chosen to
 * connect all islands.
 *
 * @param n the number of islands (nodes) to be connected.
 * @param costs an array of edges, where each entry is [from, to, cost] representing
 *              the construction cost of a bridge between two islands.
 * @return the minimum total cost required to connect all islands.
 */
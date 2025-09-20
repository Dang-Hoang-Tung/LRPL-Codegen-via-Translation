/**
 * Computes the number of reachable cells with values strictly less than each query threshold.
 *
 * For each query value, the function explores the grid starting from the top-left cell (0,0),
 * expanding into neighboring cells using BFS. Cells with values lower than the current query
 * threshold are counted as accessible, while others are deferred using a priority queue until
 * future queries with higher thresholds. Queries are processed in ascending order, and results
 * are mapped back to the original query indices.
 *
 * @param grid 2D array of integers representing cell values in the grid.
 * @param queries Array of threshold values; for each query, counts how many cells are reachable
 *                with values less than the threshold.
 * @return An integer array where each element corresponds to the count of accessible cells for
 *         the respective query in the input order.
 */
/**
 * Determines all valid next positions that can be stepped to from a given position,
 * based on elevation constraints in the heatmap grid.
 *
 * Evaluates the four orthogonal neighbors (up, down, left, right) and includes only those
 * within bounds whose elevation is at most one unit higher than the current position.
 *
 * @param position the current position in the grid.
 * @param locations a 2D grid of elevations representing the heatmap.
 * @return a list of valid neighboring positions that can be moved to.
 */
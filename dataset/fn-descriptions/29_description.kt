/**
 * Explore all possible paths from the starting point to the goal and return the maximum number of steps taken.
 *
 * This function performs a depth-first search, guided by a user-provided `nextLocations` function that defines
 * the movement rules of the traversal. It keeps track of visited points to prevent cycles, recursively explores
 * valid neighboring locations, and updates the longest path length whenever the goal is reached.
 *
 * @param nextLocations A function that, given a current location, returns a list of neighboring positions paired
 * with the step cost to reach them.
 * @return The maximum number of steps in any valid path from start to goal.
 */
/**
 * Counts the number of trees encountered when traversing the map using a given slope.
 *
 * Starting from the top-left corner, the function repeatedly moves by the given slope
 * until reaching the bottom of the map. The horizontal position wraps around when it
 * exceeds the map width. Each visited position is checked for a tree ('#'), and the
 * total count is returned.
 *
 * @param slope a pair of integers representing the rightward and downward steps per move
 * @return the total number of trees encountered along the traversal path
 */
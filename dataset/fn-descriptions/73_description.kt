/**
 * Simulates dropping a unit of sand from a starting point into the grid until it settles or falls out.
 *
 * The function checks if the starting cell is empty, then iteratively attempts to move the sand downward.
 * At each step, it first tries to fall straight down, then diagonally down-left, then diagonally down-right.
 * If no further movement is possible, the sand settles at the current location. If a `limit` is given, it
 * constrains the vertical search space. When `limitIsFloor` is true, sand will settle at the limit row even
 * if no blocking cell exists beneath it.
 *
 * @param point the initial position where sand is dropped.
 * @param limit optional maximum Y boundary; defaults to the grid's maximum Y.
 * @param limitIsFloor if true, treats the `limit` row as a floor where sand can settle.
 * @return true if the sand settles in the grid, false if it cannot be placed.
 */
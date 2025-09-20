/**
 * Simulates rope movements based on a sequence of directional instructions and counts unique positions visited.
 *
 * Initializes the starting point as visited, then iterates through all movement commands (U, D, L, R),
 * moving the rope's head by the specified offset and propagating movements to the rest of the knots.
 * Each new tail position is recorded as visited.
 *
 * @param input the puzzle input containing the movement instructions, knot positions, and visited points tracking.
 * @return the total number of unique positions visited by the rope's tail after processing all moves.
 */
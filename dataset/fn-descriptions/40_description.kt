/**
 * Determines the next position in the navigation graph based on the current location
 * and the next instruction from the infinite instruction generator.
 *
 * Retrieves the next instruction ('L' or 'R') from the generator, looks up the possible
 * destinations from the directions map, and returns the appropriate next position.
 * Throws an exception if the instruction is not recognized.
 *
 * @param generator cyclic generator producing navigation instructions ('L' or 'R')
 * @param current the current node identifier in the map
 * @param directions mapping of each node to its left and right destination nodes
 * @return the identifier of the next node to move to
 */
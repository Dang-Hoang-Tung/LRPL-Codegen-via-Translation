/**
 * Reacts a polymer string by repeatedly removing adjacent units of the same type but opposite polarity.
 *
 * Iterates through the polymer string and checks consecutive characters. If two adjacent units are the same
 * letter with opposite cases (e.g., 'a' and 'A'), both are removed from the string. After a removal, the index
 * steps back one position (if possible) to re-check for new reactions. This process continues until no more
 * reactions are possible.
 *
 * @param polymerInput the polymer string to process; defaults to the class's input if not provided
 * @return the length of the polymer after all possible reactions have occurred
 */
/**
 * Parses a string representation of a packet into a nested [Packet] structure.
 *
 * Iterates through the given packet string character by character, handling nested lists
 * via recursive calls when encountering `'['`. Digits are accumulated into a buffer to
 * allow multi-digit numbers, which are converted into `Packet` instances when a comma `','`
 * or closing bracket `']'` is reached. Each recursive call ends when a closing bracket is
 * found, returning the constructed `Packet` along with the next index position to continue from.
 *
 * @param packetString The string encoding of a packet, e.g. `[[1],[2,3,4]]`.
 * @param index The starting position for parsing within the string (defaults to 1 since
 *          packets always begin with `'['`).
 * @return A pair where the first element is the parsed [Packet] object, and the second
 *          element is the index of the next character after the closing bracket of the parsed segment.
 */
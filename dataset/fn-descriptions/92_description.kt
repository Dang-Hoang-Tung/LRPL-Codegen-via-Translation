/**
 * Decodes scrambled seven-segment display patterns into their numeric output value.
 *
 * This function takes a set of scrambled segment patterns and a list of output digit patterns,
 * deduces the correct wiring of segments by progressively narrowing down possible mappings,
 * and then translates the output patterns into their corresponding digits. It iteratively
 * eliminates impossible segment assignments until each segment is uniquely mapped, then
 * applies the resolved mapping to decode the output digits into an integer value.
 *
 * @param patterns the list of scrambled signal patterns representing all ten digits.
 * @param output the list of scrambled patterns that need to be decoded into digits.
 * @return the integer value obtained by decoding the output patterns.
 */
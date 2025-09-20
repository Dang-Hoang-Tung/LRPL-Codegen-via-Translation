/**
 * Parses a textual stack representation into a map of stack indices and crate contents.
 *
 * The function interprets the list of strings where the last line specifies the number
 * of stacks, and the preceding lines represent rows of crates. It initializes a map
 * of stack indices to mutable lists of characters, then iterates through the crate rows
 * from bottom to top, distributing crate characters into their corresponding stacks.
 * Only alphabetical characters are added to stacks, preserving their vertical order.
 *
 * @receiver List of strings representing the stacks layout, with the last line containing stack numbers.
 * @return A map where each key is a stack index and each value is a mutable list of crate characters.
 */
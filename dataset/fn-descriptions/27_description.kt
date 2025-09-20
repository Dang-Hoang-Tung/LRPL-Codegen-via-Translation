/**
 * Groups calorie values by contiguous non-empty lines and maps each group to its total sum.
 *
 * Iterates over the input list of calorie values represented as strings. Consecutive non-empty
 * values are collected into a group until an empty string is encountered, which marks the end
 * of that group. Each group is then added to the result map with the sum of its integer values
 * as the key and the original string values as the list. The last group is also added if it
 * ends without a trailing empty string.
 *
 * @param input list of strings where each string is either a calorie value or an empty separator.
 * @return a mutable map where keys are the integer sum of each group's calorie values, and
 *         values are the corresponding list of calorie strings.
 */
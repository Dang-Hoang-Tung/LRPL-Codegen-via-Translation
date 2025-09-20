/**
 * Finds the hidden lucky number between 1 and [maxNumber] using a binary search strategy.
 *
 * The function repeatedly selects a midpoint (pivot) between the current left and right bounds,
 * calls the internal `guess` function to compare it with the lucky number, and narrows down
 * the search range accordingly:
 * - If the pivot matches the lucky number, it returns the pivot immediately.
 * - If the lucky number is lower, the search continues in the left half.
 * - If the lucky number is higher, the search continues in the right half.
 * The process repeats until the number is found or the range becomes invalid.
 *
 * @param maxNumber the maximum bound of the range to search, with the range being [1, maxNumber].
 * @return the lucky number if found; -1 if no valid number is identified (error case).
 */
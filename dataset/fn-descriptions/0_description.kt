/**
 * Calculates the total amount of trapped rainwater using the two-pointer approach.
 *
 * Iterates from both ends of the array towards the center, maintaining the maximum heights
 * encountered on the left and right. At each step, water trapped is determined by the
 * difference between the current height and the maximum boundary on that side.
 *
 * @receiver IntArray representing elevation heights where each index is a bar.
 * @return The total volume of water trapped between the bars.
 */
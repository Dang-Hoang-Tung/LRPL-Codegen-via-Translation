/**
 * Rearranges the array so that even numbers come before odd numbers in-place.
 *
 * Uses a two-pointer approach: one pointer starts from the beginning and the other from the end.
 * The left pointer moves forward when it points to an even number, while the right pointer
 * moves backward when it points to an odd number. If the left points to an odd and the right
 * points to an even, the two elements are swapped. This continues until the pointers meet.
 *
 * @receiver IntArray the input array to be reordered
 * @return IntArray the same array instance with elements reordered by parity
 */
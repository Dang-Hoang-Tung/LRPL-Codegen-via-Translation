fun main() {
    fun assertEqual(actual: IntArray, expected: IntArray) {
        if (actual.size != expected.size) {
            throw IllegalStateException("Expected size ${expected.size}, but got ${actual.size}")
        }
        for (i in actual.indices) {
            if (actual[i] != expected[i]) {
                throw IllegalStateException("Mismatch at index $i: expected ${expected[i]}, got ${actual[i]}")
            }
        }
    }

    val sol = Solution()

    // Test case 1
    val result1 = sol.maxPoints(
        arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 5, 7),
            intArrayOf(3, 5, 1)
        ),
        intArrayOf(5, 6, 2)
    )
    assertEqual(result1, intArrayOf(5, 8, 1))

    // Test case 2
    val result2 = sol.maxPoints(
        arrayOf(
            intArrayOf(5, 2, 1),
            intArrayOf(1, 1, 2)
        ),
        intArrayOf(3)
    )
    assertEqual(result2, intArrayOf(0))

    println("All tests passed.")
}

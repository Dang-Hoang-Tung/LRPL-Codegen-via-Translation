fun main() {
    fun arraysEqual(a: Array<IntArray>, b: Array<IntArray>): Boolean {
        if (a.size != b.size) return false
        for (i in a.indices) {
            if (!a[i].contentEquals(b[i])) return false
        }
        return true
    }

    fun assertEquals(actual: Array<IntArray>, expected: Array<IntArray>) {
        if (!arraysEqual(actual, expected)) {
            val actualStr = actual.joinToString(prefix = "[", postfix = "]") { it.joinToString(prefix = "[", postfix = "]") }
            val expectedStr = expected.joinToString(prefix = "[", postfix = "]") { it.joinToString(prefix = "[", postfix = "]") }
            throw IllegalStateException("Assertion failed!\nExpected: $expectedStr\nActual:   $actualStr")
        }
    }

    // Test 1
    run {
        val result = Solution().buildMatrix(
            3,
            arrayOf(intArrayOf(1, 2), intArrayOf(3, 2)),
            arrayOf(intArrayOf(2, 1), intArrayOf(3, 2)),
        )
        val expected = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(3, 0, 0),
            intArrayOf(0, 2, 0),
        )
        assertEquals(result, expected)
    }

    // Test 2
    run {
        val result = Solution().buildMatrix(
            3,
            arrayOf(intArrayOf(1, 2), intArrayOf(2, 3), intArrayOf(3, 1), intArrayOf(2, 3)),
            arrayOf(intArrayOf(2, 1)),
        )
        val expected = arrayOf<IntArray>() // empty
        assertEquals(result, expected)
    }

    println("All tests passed!")
}

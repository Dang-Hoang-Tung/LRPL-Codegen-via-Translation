fun main() {
    fun assertEqual(actual: Any?, expected: Any?) {
        if (actual is Number && expected is Number) {
            if (actual.toLong() != expected.toLong()) {
                throw Error("Assertion failed: expected=$expected, actual=$actual")
            }
        } else {
            if (actual != expected) {
                throw Error("Assertion failed: expected=$expected, actual=$actual")
            }
        }
    }

    val s = Solution()

    // Original test: minCost()
    assertEqual(
        s.minCost(intArrayOf(4, 2, 2, 2), intArrayOf(1, 4, 1, 2)),
        1
    )

    // Original test: minCost2()
    assertEqual(
        s.minCost(intArrayOf(2, 3, 4, 1), intArrayOf(3, 2, 5, 1)),
        -1
    )

    println("All tests passed!")
}

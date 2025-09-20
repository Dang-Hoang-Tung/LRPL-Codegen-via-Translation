fun main() {
    val testCases = listOf(
        Pair(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6),
        Pair(intArrayOf(), 0),
        Pair(intArrayOf(1), 0),
        Pair(intArrayOf(0, 1), 0),
        Pair(intArrayOf(0, 1, 2, 1, 0, 3, 2), 3),
    )

    val strategies = listOf<RainWaterStrategy>(
        RainWaterStraightForward(),
        RainWaterStack()
    )

    for (strategy in strategies) {
        for ((input, expected) in testCases) {
            val actual = strategy.invoke(input)
            if (actual != expected) {
                throw AssertionError("Test failed for input=${input.joinToString()} with strategy=${strategy::class.simpleName}: expected=$expected, actual=$actual")
            }
        }
    }

    println("All tests passed.")
}

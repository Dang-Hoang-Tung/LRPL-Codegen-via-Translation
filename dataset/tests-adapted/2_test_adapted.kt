fun main() {
    val testCases = listOf(
        Pair(intArrayOf(), intArrayOf()),
        Pair(intArrayOf(3, 1, 2, 4), intArrayOf(4, 2, 1, 3)),
        Pair(intArrayOf(0), intArrayOf(0)),
        Pair(intArrayOf(1), intArrayOf(1)),
        Pair(intArrayOf(2, 2), intArrayOf(2, 2)),
        Pair(intArrayOf(3, 3), intArrayOf(3, 3)),
        Pair(intArrayOf(2, 2, 3), intArrayOf(2, 2, 3)),
    )

    val strategies = listOf<SortArrayByParity>(
        SortArrayByParityStream(),
        SortArrayByParityKotlin(),
        SortArrayByParityTwoPass(),
        SortArrayByParityInPlace()
    )

    for (strategy in strategies) {
        for ((input, expected) in testCases) {
            val inputCopy = input.copyOf() // avoid mutation of original input
            val actual = strategy.invoke(inputCopy)

            if (!arraysContainSameElements(actual, expected)) {
                throw AssertionError(
                    "Test failed for input=${input.joinToString()} using ${strategy::class.simpleName}.\n" +
                    "Expected=${expected.joinToString()}, Actual=${actual.joinToString()}"
                )
            }
        }
    }

    println("All tests passed.")
}

fun arraysContainSameElements(a: IntArray, b: IntArray): Boolean {
    if (a.size != b.size) return false
    val freqA = a.groupBy { it }.mapValues { it.value.size }
    val freqB = b.groupBy { it }.mapValues { it.value.size }
    return freqA == freqB
}

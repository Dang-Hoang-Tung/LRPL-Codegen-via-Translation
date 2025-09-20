fun main() {
    val testInput = """
    32T3K 765
    T55J5 684
    KK677 28
    KTJJT 220
    QQQJA 483
    """.trimIndent().split("\n")

    val testValue = part1(testInput)
    println("part1 result: $testValue")
    if (testValue != 6440L) {
        throw Error("part1 failed: expected 6440 but got $testValue")
    }

    val part2Value = part2(testInput)
    println("part2 result: $part2Value")
    if (part2Value != 5905L) {
        throw Error("part2 failed: expected 5905 but got $part2Value")
    }

    println("All tests passed!")
}

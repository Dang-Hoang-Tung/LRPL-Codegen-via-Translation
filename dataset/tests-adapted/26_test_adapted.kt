fun main() {
    val testInputRaw = """
        1000
        2000
        3000

        4000

        5000
        6000

        7000
        8000
        9000

        10000
    """

    val testInput = testInputRaw.trimIndent().lines()

    if (part1(testInput) != 24000) {
        throw IllegalStateException("part1(testInput) failed: expected 24000, got ${part1(testInput)}")
    }

    if (part2(testInput) != 45000) {
        throw IllegalStateException("part2(testInput) failed: expected 45000, got ${part2(testInput)}")
    }
    
    println("All tests passed.")
}

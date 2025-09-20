fun main() {
    val input = """
        A Y
        B X
        C Z
    """.trimIndent()

    val rps = RockPaperScissors(input)

    // part1 test
    val part1Result = rps.part1()
    if (part1Result != 15) {
        throw IllegalStateException("part1() failed: expected 15, got $part1Result")
    }

    // part2 test
    val part2Result = rps.part2()
    if (part2Result != 12) {
        throw IllegalStateException("part2() failed: expected 12, got $part2Result")
    }

    println("All tests passed!")
}

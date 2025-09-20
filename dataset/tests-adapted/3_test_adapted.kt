fun main() {
    hardcodedInput = """
        1 + 2 * 3 + 4 * 5 + 6
        1 + (2 * 3) + (4 * (5 + 6))
        2 * 3 + (4 * 5)
        5 + (8 * 3 + 9 + 3 * 4 * 3)
        5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))
        ((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2
    """.trimIndent()

    val dayEighteen = Day18()

    // Part 1 check
    val partOneResult = dayEighteen.partOne()
    if (partOneResult != 26457L) {
        throw AssertionError("partOne failed: expected=26457 but was=$partOneResult")
    }

    // Part 2 check
    val partTwoResult = dayEighteen.partTwo()
    if (partTwoResult != 694173L) {
        throw AssertionError("partTwo failed: expected=694173 but was=$partTwoResult")
    }

    // Part 1 examples
    val part1Examples = listOf(
        "1 + 2 * 3 + 4 * 5 + 6" to 71L,
        "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
        "2 * 3 + (4 * 5)" to 26L,
        "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 437L,
        "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 12240L,
        "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 13632L
    )

    for ((expr, expected) in part1Examples) {
        val actual = dayEighteen.doCalculation(expr)
        if (actual != expected) {
            throw AssertionError("Part 1 expression failed: '$expr' expected=$expected but was=$actual")
        }
    }

    // Part 2 examples
    val part2Examples = listOf(
        "1 + 2 * 3 + 4 * 5 + 6" to 231L,
        "1 + (2 * 3) + (4 * (5 + 6))" to 51L,
        "2 * 3 + (4 * 5)" to 46L,
        "5 + (8 * 3 + 9 + 3 * 4 * 3)" to 1445L,
        "5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))" to 669060L,
        "((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2" to 23340L
    )

    for ((expr, expected) in part2Examples) {
        val actual = dayEighteen.doCalculation(expr, true)
        if (actual != expected) {
            throw AssertionError("Part 2 expression failed: '$expr' expected=$expected but was=$actual")
        }
    }

    // Extra test cases for Part 2
    val extraExamples = listOf(
        "5 * 5 + 9 + (5 * 2 + 4 + 8 + 6 * 4) * 9 * 3" to 55890L,
        "9 + 9 * 2 * 8 + ((7 * 7 * 8 * 3) + 7 + 2 * 3) * 4" to 513072L,
        "4 * 8 + (2 * 5 * (3 * 7 + 3 * 6) * 9) * (2 + 4 * 6 * 2)" to 4667904L
    )

    for ((expr, expected) in extraExamples) {
        val actual = dayEighteen.doCalculation(expr, true)
        if (actual != expected) {
            throw AssertionError("Extra Part 2 expression failed: '$expr' expected=$expected but was=$actual")
        }
    }

    println("All tests passed.")
}

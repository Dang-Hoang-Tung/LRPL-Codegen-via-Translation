fun main() {
    val sampleText = listOf(
        "Sabqponm",
        "abcryxxl",
        "accszExk",
        "acctuvwj",
        "abdefghi",
    )

    val result1 = Day12.solutionOne(sampleText)
    if (result1 != 31) {
        throw IllegalStateException("Test failed for solutionOne: expected 31, got $result1")
    }

    val result2 = Day12.solutionTwo(sampleText)
    if (result2 != 29) {
        throw IllegalStateException("Test failed for solutionTwo: expected 29, got $result2")
    }

    println("All tests passed.")
}

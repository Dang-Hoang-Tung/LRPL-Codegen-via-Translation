// Self-contained test function
fun main() {
    val testInput = """
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
    """.trimIndent().lines()

    val result1 = part1(testInput)
    val expected1 = 24000
    if (result1 != expected1) {
        throw RuntimeException("part1 failed: expected $expected1 but got $result1")
    }

    val result2 = part2(testInput)
    val expected2 = 45000
    if (result2 != expected2) {
        throw RuntimeException("part2 failed: expected $expected2 but got $result2")
    }

    println("All tests passed.")
}

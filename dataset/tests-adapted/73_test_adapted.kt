fun main() {
    val testInput = listOf(
        "498,4 -> 498,6 -> 496,6\n",
        "503,4 -> 502,4 -> 502,9 -> 494,9\n",
    )

    fun assertEquals(actual: Any?, expected: Any?) {
        if (actual != expected) {
            throw IllegalStateException("Test failed: expected=$expected, actual=$actual")
        }
    }

    assertEquals(part1(testInput), 24)
    assertEquals(part2(testInput), 93)

    println("All tests passed!")
}

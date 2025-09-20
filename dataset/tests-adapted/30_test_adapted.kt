fun main() {
    fun assertEquals(actual: Int, expected: Int) {
        if (actual != expected) {
            throw IllegalStateException("Test failed: expected $expected but got $actual")
        }
    }

    // Tests
    assertEquals(part1(readInput("target area: x=20..30, y=-10..-5")), 45)
    assertEquals(part2(readInput("target area: x=20..30, y=-10..-5")), 112)

    println("All tests passed!")
}

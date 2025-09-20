fun main() {
    val it = Day05()

    val testInput = """
            [D]    
        [N] [C]    
        [Z] [M] [P]
        1   2   3

        move 1 from 2 to 1
        move 3 from 1 to 3
        move 2 from 2 to 1
        move 1 from 1 to 2
    """.trimIndent()

    // Run part1
    val testResult1 = it.part1(testInput)
    println("First test result: $testResult1")
    if (testResult1 != it.testResult1()) {
        throw IllegalStateException("Expected ${it.testResult1()} but got $testResult1")
    }

    // Run part2
    val testResult2 = it.part2(testInput)
    println("Second test result: $testResult2")
    if (testResult2 != it.testResult2()) {
        throw IllegalStateException("Expected ${it.testResult2()} but got $testResult2")
    }

    println("All tests passed!")
}

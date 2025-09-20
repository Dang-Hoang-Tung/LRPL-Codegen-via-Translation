fun main() {
    val input = """
        [1,1,3,1,1]
        [1,1,5,1,1]

        [[1],[2,3,4]]
        [[1],4]

        [9]
        [[8,7,6]]

        [[4,4],4,4]
        [[4,4],4,4,4]

        [7,7,7,7]
        [7,7,7]

        []
        [3]

        [[[]]]
        [[]]

        [1,[2,[3,[4,[5,6,7]]]],8,9]
        [1,[2,[3,[4,[5,6,0]]]],8,9]
    """.trimIndent()

    val day = Day13()
    val packets = day.parseInput(input)

    val result1 = day.part1(packets)
    if (result1 != 13) {
        throw IllegalStateException("part1 failed: expected 13, got $result1")
    }

    val result2 = day.part2(packets)
    if (result2 != 140) {
        throw IllegalStateException("part2 failed: expected 140, got $result2")
    }

    println("All tests passed.")
}

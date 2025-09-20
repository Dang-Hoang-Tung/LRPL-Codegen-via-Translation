fun main() {
    val sut = P42861()

    fun assertEqual(actual: Int, expected: Int) {
        if (actual != expected) {
            throw IllegalStateException("Assertion failed: expected=$expected, actual=$actual")
        }
    }

    // example 1
    assertEqual(
        sut.solution(
            4, arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(0, 2, 2),
                intArrayOf(1, 2, 5),
                intArrayOf(1, 3, 1),
                intArrayOf(2, 3, 8)
            )
        ),
        4
    )

    // example 2
    assertEqual(
        sut.solution(
            7, arrayOf(
                intArrayOf(2, 3, 7),
                intArrayOf(3, 6, 13),
                intArrayOf(3, 5, 23),
                intArrayOf(5, 6, 25),
                intArrayOf(0, 1, 29),
                intArrayOf(1, 5, 34),
                intArrayOf(1, 2, 35),
                intArrayOf(4, 5, 53),
                intArrayOf(0, 4, 75)
            )
        ),
        159
    )

    // example 3
    assertEqual(
        sut.solution(
            5, arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(1, 2, 3),
                intArrayOf(2, 3, 3),
                intArrayOf(3, 1, 2),
                intArrayOf(3, 0, 4),
                intArrayOf(2, 4, 6),
                intArrayOf(4, 0, 7)
            )
        ),
        15
    )

    println("All tests passed.")
}

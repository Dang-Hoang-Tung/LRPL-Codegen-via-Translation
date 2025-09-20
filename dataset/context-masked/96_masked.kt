class RockPaperScissors(
    private val input: String
) {
    private fun readRockPaperScissors(): List<Pair<Char, Char>> {
        return input.lines().map { line ->
            return@map (line.first()) to (line.last())
        }
    }

    fun part1(): Int {
        /* GENERATE THIS FUNCTION */
    }

    fun part2(): Int {
        val strategy = listOf(3, 1, 2, 3, 1)
        return readRockPaperScissors()
            .map { round ->
                val shape = round.first - 'A' + 1
                return@map when (round.second) {
                    'X' -> 0 + strategy[shape - 1]
                    'Y' -> 3 + shape
                    else -> 6 + strategy[shape + 1]
                }
            }
            .sum()
    }
}

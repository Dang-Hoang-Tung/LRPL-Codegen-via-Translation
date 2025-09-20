package day02

import readInput

class RockPaperScissors(
    private val name: String
) {
    private fun readRockPaperScissors(): List<Pair<Char, Char>> {
        return readInput(name).map { line ->
            return@map (line.first()) to (line.last())
        }
    }

    fun part1(): Int {
        return readRockPaperScissors()
            .map { round ->
                (round.first - 'A' + 1) to (round.second - 'X' + 1)
            }
            .fold(0) { score, round ->
                val outcome = when (round.second - round.first) {
                    0 -> 3
                    1 -> 6
                    -2 -> 6
                    else -> 0
                }
                val shape = round.second
                return@fold score + shape + outcome
            }
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

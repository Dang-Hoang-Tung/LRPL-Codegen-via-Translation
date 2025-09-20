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
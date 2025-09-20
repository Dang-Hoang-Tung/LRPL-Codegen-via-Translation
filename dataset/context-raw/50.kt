fun main() {
    fun scissors(move: Char): Int {
        return when (move) {
            'X' -> 1 + 6
            'Y' -> 2 + 0
            'Z' -> 3 + 3
            else -> 0
        }
    }

    fun rock(move: Char): Int {
        return when (move) {
            'X' -> 1 + 3
            'Y' -> 2 + 6
            'Z' -> 3 + 0
            else -> 0
        }
    }

    fun paper(move: Char): Int {
        return when (move) {
            'X' -> 1 + 0
            'Y' -> 2 + 3
            'Z' -> 3 + 6
            else -> 0
        }
    }

    fun part1(input: List<String>): Int {
        var total = 0

        for (line in input) {
            when (line[0]) {
                'C' -> total += scissors(line[2])
                'A' -> total += rock(line[2])
                'B' -> total += paper(line[2])
            }
        }

        return total
    }

    fun win(input: Char): Int {
        return when (input) {
            'A' -> 6 + 2
            'B' -> 6 + 3
            'C' -> 6 + 1
            else -> 0
        }

    }

    fun lose(input: Char): Int {
        return when (input) {
            'A' -> 3
            'B' -> 1
            'C' -> 2
            else -> 0
        }

    }

    fun tie(input: Char): Int {
        return when (input) {
            'A' -> 3 + 1
            'B' -> 3 + 2
            'C' -> 3 + 3
            else -> 0
        }

    }

    fun part2(input: List<String>): Int {
        var total = 0

        for (line in input) {
            when (line[2]) {
                'X' -> total += lose(line[0])
                'Y' -> total += tie(line[0])
                'Z' -> total += win(line[0])
            }
        }

        return total
    }



    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

import java.io.File

fun readInput(name: String) = File("src/main/resources", "$name.txt").readLines()

val testInput = readInput("Day07_test")
check(part1(testInput) == 95437L)
check(part2(testInput) == 0)

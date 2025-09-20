interface Day<T> {
    fun getInput(): T
    fun part1(input: T): Any
    fun part2(input: T): Any

    fun run() {
        val input = getInput()
        warmup(input)
        var start = System.nanoTime()
        println("Part 1: ${part1(input)} (${(System.nanoTime() - start) / 1_000_000.0}ms)")
        start = System.nanoTime()
        println("Part 2: ${part2(input)} (${(System.nanoTime() - start) / 1_000_000.0}ms)")
    }

    fun readInputFile(day: String): String {
        return this.javaClass.classLoader.getResource("day$day.txt")!!
            .readText()
    }

    /**
     * Run this code before performance testing. Use this to run code to trigger compiler optimization.
     *
     * The default is a no-op method. Override to provide Day specific optimization code.
     *
     * Any code executed in this method will not be timed during part 1 or part 2
     */
    fun warmup(input: T) {
        //No-op
    }
}

fun gcd(num1: Long, num2: Long): Long {
    if (num2 == 0L) {
        return num1
    }
    return gcd(num2, num1 % num2)
}

fun lcm(numbers: List<Long>): Long {
    var lcm = numbers[0]
    for (i in 1 until numbers.size) {
        val num1 = lcm
        val num2 = numbers[i]
        val gcdValue = gcd(num1, num2)
        lcm = (lcm * num2) / gcdValue
    }
    return lcm
}

typealias Direction = Map<String, Pair<String,String>>

/**
 * Day 8: Haunted Wasteland
 *
 * The puzzle input consists of two parts. The first part is a set of instructions indicating which
 * direction to take (R = right, L = left). Those instructions repeat forever.
 * The second part maps a starting position to two possible ending positions (a left and a right)
 */
class Day8: Day<Pair<String, Direction>> {
    override fun getInput(): Pair<String, Direction> {
        return parseInput(readInputFile("8"))
    }

    /**
     * Part1: The starting position is AAA and the ending position is ZZZ
     * Following the instructions, how many steps does it take to get to the end?
     */
    override fun part1(input: Pair<String, Direction>): Int {
        val (instructionString, directions) = input
        val instructionGenerator = InfiniteGenerator(instructionString.toCharArray().toList())
        var current = "AAA"
        while (current != "ZZZ") {
            current = nextPosition(instructionGenerator, current, directions)
        }
        return instructionGenerator.num
    }

    /**
     * Part 2: There are multiple starting points (every position that ends with A)
     * and multiple ending points (every position that ends with Z)
     *
     * Starting at all possible starting locations at the same time, how many steps until
     * each position has reached and end point at the same time?
     */
    override fun part2(input: Pair<String, Direction>): Long {
        val (instructionString, directions) = input
        val currentPositions = directions.keys.filter { it.endsWith("A") }.toMutableList()

        // find how long it takes to reach the end from each starting position
        val endIndexes = currentPositions.map { start ->
            var current = start
            val instructionGenerator = InfiniteGenerator(instructionString.toCharArray().toList())
            while (!current.endsWith("Z")){
                current = nextPosition(instructionGenerator, current, directions)
            }
            instructionGenerator.num.toLong()
        }

        // Note: This only works because for this puzzle, the repeating pattern of the instructions
        // starts at the same time for each starting location. That does not necessarily have to be true
        return lcm(endIndexes)
    }

    fun parseInput(input: String): Pair<String, Direction> {
        val (instructions, directionList) = input.split("\n\n")
        val directionMap = directionList.lines().map { line ->
            val (key, lrPair) = line.split(" = ")
            val (left, right) = lrPair.removeSuffix(")").removePrefix("(").split(", ")
            Pair(key, Pair(left, right))
        }.associate { (key, pair) -> key to pair }.toMap()
        return Pair(instructions, directionMap)
    }

    private fun nextPosition(generator: InfiniteGenerator<Char>, current: String, directions: Direction): String {
        /* GENERATE THIS FUNCTION */
    }

    override fun warmup(input: Pair<String, Direction>) {
        part1(input)
    }
}

class InfiniteGenerator<T>(private val order: List<T>) {
    var num = 0
    fun next(): T {
        return order[num % order.size].also { num++ }
    }
}

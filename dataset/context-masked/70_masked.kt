import java.io.File
import kotlin.math.abs

open class PuzzleInput<T>(val expectedResult: T? = null)
abstract class Puzzle<T, P : PuzzleInput<T>> {
    fun solve(input: P) {
        val solution = solution(input)
        if(input.expectedResult != null) {
            if(solution != input.expectedResult) {
                println("$solution == ${input.expectedResult}")
            }
            check(solution == input.expectedResult)
        }
        else {
            println(solution)
        }
    }

    abstract fun solution(input: P) : T
}

class Day9PuzzleInput(val input: String, numKnots: Int, expectedResult: Int? = null) : PuzzleInput<Int>(expectedResult) {
    val moves = input.lines()
    val pointsVisited = HashMap<Pair<Int, Int>, Boolean>()
    private val knots = Array(numKnots) {
        Pair(0, 0)
    }

    private fun getKnot(head: Pair<Int, Int>, tail: Pair<Int, Int>): Pair<Int, Int> {
        val x = head.first - tail.first
        val y = head.second - tail.second
        if(abs(x) > 1 || abs(y) > 1) {
            return Pair(tail.first + x.coerceIn(-1, 1), tail.second + y.coerceIn(-1, 1))
        }
        return tail
    }

    private fun moveHead(newHead: Pair<Int, Int>) {
        knots[0] = newHead
        for(i in 1 until knots.size) {
            knots[i] = getKnot(knots[i-1], knots[i])
        }
        pointsVisited[knots.last()] = true
    }
    fun moveHead(xOffset: Int, yOffset: Int, amount: Int) {
        for(move in 1 .. amount) {
            moveHead(Pair(knots[0].first + xOffset, knots[0].second + yOffset))
        }
    }
}

class Day9PuzzleSolution : Puzzle<Int, Day9PuzzleInput>() {
    override fun solution(input: Day9PuzzleInput): Int {
        /* GENERATE THIS FUNCTION */
    }
}

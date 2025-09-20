import java.nio.file.Files
import java.nio.file.Paths
import kotlin.math.absoluteValue
import kotlin.math.sign

fun part1(input: Input): Int {
    val (xRange, yRange) = input.toList().map { it.first..it.second }
    require(xRange.first > 0 && xRange.last >= xRange.first)
    require(yRange.last < 0 && yRange.last >= yRange.first)
    // assume we can find X such that X * (X + 1) / 2 in xRange and X <= Y * 2 + 1
    // works for my test case, YMMW
    val y = yRange.first.absoluteValue - 1
    return y * (y + 1) / 2
}

fun part2(input: Input): Int {
    val (xRange, yRange) = input.toList().map { it.first..it.second }
    require(xRange.first > 0 && xRange.last >= xRange.first)
    require(yRange.last < 0 && yRange.last >= yRange.first)
    var answer = 0
    for (xv in 1..xRange.last) {
        for (yv in yRange.first..yRange.first.absoluteValue) {
            var (cx, cy) = 0 to 0
            var (cxv, cyv) = xv to yv
            while (true) {
                cx += cxv.also { cxv -= cxv.sign }
                cy += cyv--
                if (cx in xRange && cy in yRange) {
                    answer++
                    break
                }
                if (cx > xRange.last || cy < yRange.first) break
            }
        }
    }
    return answer
}

private fun readInput(s: String): Input {
    return s.let { line ->
        val (xRange, yRange) = line.substring("target area: ".length).split(", ")
        val (xMin, xMax) = xRange.substring("x=".length).split("..").map { it.toInt() }
        val (yMin, yMax) = yRange.substring("y=".length).split("..").map { it.toInt() }
        Pair(xMin to xMax, yMin to yMax)
    }
}

private typealias Input = Pair<Pair<Int, Int>, Pair<Int, Int>>

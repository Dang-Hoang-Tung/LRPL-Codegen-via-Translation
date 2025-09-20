import kotlin.math.sign

data class Point(val x: Int, val y: Int) {
    val neighbours: Set<Point>
        get() = listOf(
            Point(-1, -1), Point(0, -1), Point(1, -1),
            Point(-1, 0), /*  this   */  Point(1, 0),
            Point(-1, 1), Point(0, 1), Point(1, 1),
        ).map { vector -> this + vector }
            .toSet()

    val orthogonalNeighbours: Set<Point>
        get() = listOf(
            Point(0, -1),
            Point(-1, 0), Point(1, 0),
            Point(0, 1),
        ).map { vector -> this + vector }
            .toSet()

    val diagonalNeighbours: Set<Point>
        get() = listOf(
            Point(-1, -1), Point(1, -1),
            Point(-1, 1), Point(1, 1),
        ).map { vector -> this + vector }
            .toSet()

    fun isDiagonalTo(other: Point): Boolean = this in other.diagonalNeighbours

    operator fun plus(vector: Point) = Point(x + vector.x, this.y + vector.y)
    operator fun times(multiplier: Int) = Point(x = x * multiplier, y = y * multiplier)
    operator fun rangeTo(other: Point): Set<Point> {
        var cur = this
        val points = mutableSetOf(cur)
        while (cur != other) {
            cur += cur.determineVectorTo(other)
            points.add(cur)
        }
        return points
    }
    infix fun until(other: Point) = (this..other) - other

    private fun determineVectorTo(other: Point): Point {
        return if (this.x == other.x) Point(0, (other.y - this.y).sign)
        else if (this.y == other.y) Point((other.x - this.x).sign, 0)
        else Point((other.x - this.x).sign, (other.y - this.y).sign)
    }

    fun searchRight(pointPredicate: (Point) -> Boolean) : Point? =
        if (pointPredicate(this + Point(1,0))) { this + Point(1,0) }
        else null

    companion object {
        fun at(x:Int, y: Int) = Point(x,y)
    }
}

fun String.parse() =
    Schematic(lines().flatMapIndexed { y, line ->
        line.mapIndexed { x, char ->
            Point(x, y) to char
        }
    }.toMap())
typealias Gear = Pair<Point, Set<Int>>

val Gear.ratio get() = this.second.map { it.toLong() }.reduce(Long::times)

class Schematic(private val points: Map<Point, Char>) {

    fun allGears(): List<Gear> {
        val numbersNextToAsterisks = allNumbersAdjacentToSymbol('*').toMap()
        val allAsterisks = points.filterValues { it == '*' }.keys
        return allAsterisks.map { asterisk ->
            asterisk to numbersNextToAsterisks.filterValues { points -> points.any { point -> point in asterisk.neighbours } }.keys
        }.filter { (_,numbers) -> numbers.size == 2 }
    }

    fun allNumbersAdjacentToSymbol(symbol: Char? = null): List<Pair<Int, List<Point>>> =
        allNumbers().filter { (_, points) ->
            points.any { point -> point.isAdjacentToASymbol(symbol) }
        }

    private fun Point.isAdjacentToASymbol(symbol: Char? = null) =
        neighbours.any { neighbour ->
            neighbour in this@Schematic.points.filterValues {
                if (symbol == null) !it.isDigit() && it != '.'
                else it == symbol
            }.keys
        }

    fun allNumbers(): List<Pair<Int, List<Point>>> {
        /* GENERATE THIS FUNCTION */
    }
}

fun solve(string: String) = string.parse().allNumbersAdjacentToSymbol().sumOf { (n, _) -> n }
fun solve2(string: String) = string.parse().allGears().sumOf { it.ratio }

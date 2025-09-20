import kotlin.math.absoluteValue

class Point(
    val x: Int,
    val y: Int
) {
    enum class Relationship {
        HORIZONTAL, VERTICAL, DIAGONAL, SKEW, EQUAL
    }

    override fun equals(other: Any?): Boolean {
        if (super.equals(other)) {
            return true
        }
        val point = other as? Point
        return point?.x == x && point.y == y
    }

    operator fun plus(other: Point): Point {
        return Point(other.x + x, other.y + y)
    }

    override fun hashCode(): Int {
        return x + y.rotateLeft(Int.SIZE_BITS/2)
    }

    companion object {
        fun fromString(str: String): Point{
            val (x, y) = str.trim().split(',').map { it.toInt() }
            return Point(x,y)
        }

        fun fromStringOrNull(str: String): Point? {
            return try { fromString(str) } catch (e: Exception) { null }
        }
    }

    fun relationshipTo(point: Point): Relationship {
        return if (point.x == x) {
            if (point.y == y) {
                Relationship.EQUAL
            } else {
                Relationship.VERTICAL
            }
        } else if (point.y == y) {
            Relationship.HORIZONTAL
        } else if ((point.y - y).absoluteValue == (point.x - x).absoluteValue) {
            Relationship.DIAGONAL
        } else {
            Relationship.SKEW
        }
    }

    infix fun to(point: Point): List<Point> {
        val relationship = relationshipTo(point)
        return when (relationship) {
            Relationship.EQUAL, Relationship.VERTICAL -> {
                if (point.y >= y) {
                    (y..point.y).map { Point(x, it) }
                } else {
                    (y downTo point.y).map { Point(x, it) }
                }
            }
            Relationship.HORIZONTAL -> {
                if (point.x >= x) {
                    (x..point.x).map { Point(it, y) }
                } else {
                    (x downTo point.x).map { Point(it, y) }
                }
            }
            Relationship.DIAGONAL -> {
                val xRange =
                    if (point.x >= x) {
                        (x..point.x)
                    } else {
                        (x downTo point.x)
                    }
                val yRange =
                    if (point.y >= y) {
                        (y..point.y)
                    } else {
                        (y downTo point.y)
                    }
                (xRange zip yRange).map { (x,y) -> Point(x, y) }
            }
            Relationship.SKEW -> {
                throw IllegalArgumentException("Points are non-linear")
            }
        }
    }

    fun cardinalDirectionsFromPoint(distance: Int = 0): List<Point> {
        return listOf(
            Point(x-1, y),
            Point(x+1, y),
            Point(x, y-1),
            Point(x, y+1),
        )
    }

    fun manhattanDistanceTo(point: Point): Int {
        return (point.x - x).absoluteValue + (point.y - y).absoluteValue
    }
    override fun toString(): String {
        return "Point(${x}, ${y})"
    }
}

class Grid {
    operator fun get(x: Int, y: Int): Int {
        return grid[y]?.get(x) ?: 0
    }

    operator fun set(x: Int, y: Int, value: Int) {
        grid.getOrPut(y) { mutableMapOf() }[x] = value
    }

    operator fun get(point: Point): Int {
        return get(point.x, point.y)
    }

    operator fun set(point: Point, value: Int) {
        set(point.x, point.y, value)
    }

    val grid = mutableMapOf<Int, MutableMap<Int, Int>>()

    override fun toString(): String {
        return grid.toString()
    }

    fun allPoints(): List<Pair<Pair<Int, Int>, Int>> {
        return grid.flatMap { (y, dict) -> dict.map { (x, count) -> Pair(Pair(x,y), count) } }
    }
}

const val rock = 1
const val sand = 2

val Grid.maxY: Int get() {
    return this.grid.keys.max()
}

fun Grid.addSandAt(point: Point, limit: Int? = null, limitIsFloor: Boolean = false): Boolean {
    if (this[point] != 0) return false
    var x = point.x
    var lastY = (limit ?: maxY) - 1
    for (y in (point.y..lastY)) {
        val nextY = y + 1
        if (this[x,nextY] == 0) continue
        if (this[x-1,nextY] == 0) {
            x=x-1
            continue
        }
        if (this[x+1,nextY] == 0){
            x=x+1
            continue
        }
        this[x,y] = sand
        return true
    }

    if (limitIsFloor) {
        this[x,lastY] = sand
        return true
    }
    return false
}

fun part1(input: List<String>): Int {
    val cave = Grid()
    for (line in input) {
        val points = line.split("->").map { Point.fromString(it) }
        for (ix in 1 until points.size) {
            val (pt1, pt2) = points.subList(ix-1, ix+1)
            (pt1 to pt2).forEach { cave[it] = rock }
        }
    }

    var count = 0
    val limit = cave.maxY
    while (cave.addSandAt(Point(500,0),limit)) ++count

    return count
}

fun part2(input: List<String>): Int {
    val cave = Grid()
    for (line in input) {
        val points = line.split("->").map { Point.fromString(it) }
        for (ix in 1 until points.size) {
            val (pt1, pt2) = points.subList(ix-1, ix+1)
            (pt1 to pt2).forEach { cave[it] = rock }
        }
    }

    var count = 0
    val limit = cave.maxY + 2
    while (cave.addSandAt(Point(500,0), limit, true)) ++count

    return count
}

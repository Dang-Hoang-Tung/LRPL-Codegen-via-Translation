fun allNumbers(): List<Pair<Int, List<Point>>> {
    val maxX = points.maxOf { (k, _) -> k.x }
    val maxY = points.maxOf { (k, _) -> k.y }
    val numbers = mutableListOf<Pair<Int, List<Point>>>()

    (0..maxY).forEach { y ->
        (0..maxX).forEach { x ->
            val point = Point(x, y)
            if (point !in numbers.flatMap { it.second } && points[point]?.isDigit() == true) {
                var curNumber = "${points[point]}"
                val curPoints = mutableListOf(point)
                var curPoint = point
                while (curPoint.searchRight { p -> points[p]?.isDigit() == true } != null) {
                    val rightNeighbour = curPoint.searchRight { p -> points[p]?.isDigit() == true }
                    curNumber += "${points[rightNeighbour]}"
                    curPoints += rightNeighbour!!
                    curPoint = rightNeighbour!!
                }
                numbers += curNumber.toInt() to curPoints
            }
        }
    }
    return numbers
}
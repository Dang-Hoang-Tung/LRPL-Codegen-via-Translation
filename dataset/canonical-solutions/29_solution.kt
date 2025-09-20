private fun traverse(nextLocations: (Point2D) -> List<Pair<Point2D, Int>>): Int {
    var best = 0
    val visited = mutableSetOf<Point2D>()

    fun traverseWork(location: Point2D, steps: Int):Int {
        if (location == goal) {
            best = max(steps, best)
            return best
        }
        visited += location
        nextLocations(location)
            .filter { (place, _) -> place !in visited }
            .forEach { (place, distance) -> traverseWork(place, distance + steps) }
        visited -= location
        return best
    }

    return traverseWork(start, 0)
}
private fun potentialSteps(position: Position, locations: List<List<Int>>): List<Position> {
    val elevation = locations[position.row][position.column]
    val possibleOtherPositions = mutableListOf<Position>()

    // up
    if (position.row > 0 && locations[position.row - 1][position.column] <= elevation + 1) {
        possibleOtherPositions.add(Position(position.row - 1, position.column))
    }

    // down
    if (position.row < locations.size - 1 && locations[position.row + 1][position.column] <= elevation + 1) {
        possibleOtherPositions.add(Position(position.row + 1, position.column))
    }

    // left
    if (position.column > 0 && locations[position.row][position.column - 1] <= elevation + 1) {
        possibleOtherPositions.add(Position(position.row, position.column - 1))
    }

    // right
    if (position.column < locations.first().size - 1 && locations[position.row][position.column + 1] <= elevation + 1) {
        possibleOtherPositions.add(Position(position.row, position.column + 1))
    }

    return possibleOtherPositions
}
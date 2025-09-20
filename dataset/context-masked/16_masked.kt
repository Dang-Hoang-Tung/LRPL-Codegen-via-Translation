// import readInput

import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", name)
    .readLines()

// import util.toAlphabetPosition

/**
 * Identifies the position in the alphabet starting at 'a' = 1 and 'A' = 27
 */
fun Char.toAlphabetPosition(): Int {
    if (!isLetter()) {
        throw IllegalArgumentException("Passed in non letter.")
    }

    return when (isLowerCase()) {
        true -> code - 'a'.code + 1
        else -> code - 'A'.code + 27
    }
}

data class Position(
    val row: Int,
    val column: Int
)

data class Heatmap (
    val startingPosition: Position,
    val endingPosition: Position,
    val locations: List<List<Int>>
)

object Day12 {

    /**
     * @return
     */
    fun solutionOne(text: List<String>): Int {
        val startingElevation = 'a'.toAlphabetPosition()
        val endingElevation = 'z'.toAlphabetPosition()

        val heatmap = parseText(
            text = text,
            startingElevation = startingElevation,
            endingElevation = endingElevation
        )

        val path = findPath(heatmap, heatmap.startingPosition, heatmap.endingPosition)!!
        return path.size - 1
    }

    /**
     * @return
     */
    fun solutionTwo(text: List<String>): Int {
        val startingElevation = 'a'.toAlphabetPosition()
        val endingElevation = 'z'.toAlphabetPosition()

        val heatmap = parseText(
                text = text,
                startingElevation = startingElevation,
                endingElevation = endingElevation
        )

        val lowestLocations = mutableListOf<Position>()
        heatmap.locations.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { colIndex, height ->
                if (height == 1) {
                    lowestLocations.add(Position(rowIndex, colIndex))
                }
            }
        }

        return lowestLocations
            .mapNotNull { position ->
                findPath(heatmap, position, heatmap.endingPosition)?.size
            }
            .minByOrNull { it }!! - 1
    }

    private fun parseText(
        text: List<String>,
        startingElevation: Int,
        endingElevation: Int
    ): Heatmap {

        var startingPosition = Position(0, 0)
        var endingPosition = Position(0,0)

        val locations = text.mapIndexed() { row, line ->
            line.mapIndexed { column, letter ->
                when (letter) {
                    'S' -> {
                        startingPosition = Position(row, column)
                        startingElevation
                    }
                    'E' -> {
                        endingPosition = Position(row, column)
                        endingElevation
                    }
                    else -> letter.toAlphabetPosition()
                }
            }
        }

        return Heatmap(
            startingPosition = startingPosition,
            endingPosition = endingPosition,
            locations = locations
        )
    }

    private fun findPath(heatmap: Heatmap, startingPosition: Position, endingPosition: Position): List<Position>? {
        val shortestDistance = mutableMapOf<Position, List<Position>>()
        val toEvaluateDistance = mutableListOf<Pair<List<Position>, Position>>() // path to positionToEvaluate

        val startingElevation = heatmap.locations[startingPosition.row][startingPosition.column]

        shortestDistance[startingPosition] = listOf(startingPosition)
        val potentialSteps = potentialSteps(startingPosition, heatmap.locations)
        potentialSteps.forEach { position ->
            toEvaluateDistance.add(listOf(startingPosition) to position)
        }

        while (toEvaluateDistance.isNotEmpty()) {
            val (path, position) = toEvaluateDistance.removeFirst()
            val fullPath = path + position

            when (val previousShortest = shortestDistance[position]) {
                null -> {
                    shortestDistance[position] = fullPath
                    potentialSteps(position, heatmap.locations).forEach { potentialNextStep ->
                        toEvaluateDistance.add(fullPath to potentialNextStep)
                    }
                }
                else -> {
                    if (fullPath.size < previousShortest.size) {
                        shortestDistance[position] = fullPath
                        potentialSteps(position, heatmap.locations).forEach { potentialNextStep ->
                            toEvaluateDistance.add(fullPath to potentialNextStep)
                        }
                    }
                }
            }
        }

        return shortestDistance[endingPosition]
    }

    private fun potentialSteps(position: Position, locations: List<List<Int>>): List<Position> {
        /* GENERATE THIS FUNCTION */
    }
}

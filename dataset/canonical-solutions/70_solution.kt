override fun solution(input: Day9PuzzleInput): Int {
    input.pointsVisited[Pair(0, 0)] = true
    input.moves.forEach { move ->
        val moveParts = move.split(" ")
        val direction = moveParts[0]
        val amount = moveParts[1].toInt()
        when(direction) {
            "U" -> input.moveHead(0, 1, amount)
            "D" -> input.moveHead(0, -1, amount)
            "L" -> input.moveHead(-1, 0, amount)
            "R" -> input.moveHead(1, 0, amount)
        }
    }

    return input.pointsVisited.size
}
private fun nextPosition(generator: InfiniteGenerator<Char>, current: String, directions: Direction): String {
    return when(val instruction = generator.next()) {
        'L' -> directions.getValue(current).first
        'R' -> directions.getValue(current).second
        else -> throw IllegalArgumentException("Invalid instruction $instruction")
    }
}
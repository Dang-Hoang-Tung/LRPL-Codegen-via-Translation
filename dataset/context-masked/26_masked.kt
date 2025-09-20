fun part1(input: List<String>): Int {
    return input.split { string -> string.isEmpty() }
        .map { list ->
            list.sumOf { string -> string.toInt() }
        }.max()
}

fun part2(input: List<String>): Int {
    return input.split { string -> string.isEmpty() }
        .map { list ->
            list.sumOf { string -> string.toInt() }
        }.sortedDescending()
        .take(3)
        .sum()
}

fun <T : Any> List<T>.split(isMarker: (T) -> Boolean): List<List<T>> {
    /* GENERATE THIS FUNCTION */
}

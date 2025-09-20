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
    val result = mutableListOf<List<T>>()
    var previousIndex = 0
    forEachIndexed { index, value ->
        if (isMarker(value)) {
            result.add(subList(previousIndex, index))
            previousIndex = index + 1
        } else if (index == size -1) {
            result.add(subList(previousIndex, size))
        }
    }
    return result
}

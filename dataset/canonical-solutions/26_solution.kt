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
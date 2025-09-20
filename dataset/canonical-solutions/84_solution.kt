private fun getValue(N: Int, i: Int): Pair<Int, Int> {
    require(i >= 0)
    var value = N - i
    if (i % 4 == 3) return value to i + 1
    check(i % 4 == 0)
    if (i < N - 1) {
        value *= N - i - 1
        if (i < N - 2) {
            value /= N - i - 2
        }
    }
    return if (i == 0) {
        value to 3
    } else {
        value * -1 to i + 3
    }
}
fun guessNumber(maxNumber: Int): Int {
    var right = maxNumber
    var left = 1
    var pivot: Int
    while (left <= right) {
        pivot = left + (right - left) / 2
        val guessResult = guess(pivot)
        when (guessResult) {
            0 -> return pivot
            -1 -> right = pivot
            1 -> left = pivot + 1
        }
    }
    return -1
}
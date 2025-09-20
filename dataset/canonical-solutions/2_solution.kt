private fun IntArray.sortArrayByParity(): IntArray {
    var i = 0
    var j = size - 1
    while (i < j) {
        if (this[i].isEven) {
            i++
        } else {
            if (!this[j].isEven) {
                j--
            }
            if (this[j].isEven) {
                swap(i, j)
                i++
                j--
            }
        }
    }
    return this
}
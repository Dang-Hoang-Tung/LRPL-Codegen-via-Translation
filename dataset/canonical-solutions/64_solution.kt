private fun search(cur: Int, pe: IntArray, onesol: MutableList<Int>, n: Int) {
    if (cur == (1 shl n) - 1) {
        if (sol.isEmpty() || onesol.size < sol.size) {
            sol = ArrayList(onesol)
        }
        return
    }
    if (sol.isNotEmpty() && onesol.size >= sol.size) {
        return
    }
    var zeroBit = 0
    while (cur shr zeroBit and 1 == 1) zeroBit++
    for (i in pe.indices) {
        val per = pe[i]
        if (per shr zeroBit and 1 == 1) {
            onesol.add(i)
            search(cur or per, pe, onesol, n)
            onesol.removeAt(onesol.size - 1)
        }
    }
}
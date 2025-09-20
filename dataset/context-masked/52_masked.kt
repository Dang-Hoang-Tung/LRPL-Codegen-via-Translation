// https://github.com/antop-dev/algorithm/issues/530
class P42861 {

    fun solution(n: Int, costs: Array<IntArray>): Int {
        /* GENERATE THIS FUNCTION */
    }

    private fun IntArray.find(x: Int): Int = if (this[x] == x) x else find(this[x])

    private fun IntArray.union(x: Int, y: Int) {
        this[find(y)] = find(x)
    }

}

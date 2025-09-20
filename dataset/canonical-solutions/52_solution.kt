fun solution(n: Int, costs: Array<IntArray>): Int {
    costs.sortBy { (_, _, cost) -> cost }
    val root = IntArray(n) { it }
    var ans = 0
    var count = 0
    for ((from, to, cost) in costs) {
        if (root.find(from) == root.find(to)) continue
        ans += cost
        root.union(from, to)
        if (count++ >= n) break
    }
    return ans
}
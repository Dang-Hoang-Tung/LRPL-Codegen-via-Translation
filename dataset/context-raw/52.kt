package kr.co.programmers

// https://github.com/antop-dev/algorithm/issues/530
class P42861 {

    fun solution(n: Int, costs: Array<IntArray>): Int {
        // 건설 비용이 낮은 순으로 정렬
        costs.sortBy { (_, _, cost) -> cost }
        // Union-Find
        val root = IntArray(n) { it }
        var ans = 0
        var count = 0
        for ((from, to, cost) in costs) {
            // 두 정점의 부모 정점이 같다면 패스 (루프)
            if (root.find(from) == root.find(to)) continue
            // 비용 누적
            ans += cost
            // 부모를 합쳐준다.
            root.union(from, to)
            // 간선은 (N-1)개가 만들어진다.
            if (count++ >= n) break
        }
        return ans
    }

    private fun IntArray.find(x: Int): Int = if (this[x] == x) x else find(this[x])

    private fun IntArray.union(x: Int, y: Int) {
        this[find(y)] = find(x)
    }

}

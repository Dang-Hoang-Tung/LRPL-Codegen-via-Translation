fun maxPoints(grid: Array<IntArray>, queries: IntArray): IntArray {
    val r = grid.size
    val c = grid[0].size
    val res = IntArray(queries.size)
    val index = arrayOfNulls<Int>(queries.size)
    for (i in queries.indices) {
        index[i] = i
    }
    Arrays.sort(index, { o: Int?, m: Int? -> queries[o!!].compareTo(queries[m!!]) })
    val q1: Queue<IntArray> = ArrayDeque()
    val q2 = PriorityQueue({ a: IntArray, b: IntArray -> a[2].compareTo(b[2]) })
    q2.offer(intArrayOf(0, 0, grid[0][0]))
    val visited = Array(r) { BooleanArray(c) }
    var count = 0
    visited[0][0] = true
    for (i in queries.indices) {
        val currLimit = queries[index[i]!!]
        while (q2.isNotEmpty() && q2.peek()[2] < currLimit) {
            q1.offer(q2.poll())
        }
        while (q1.isNotEmpty()) {
            val curr = q1.poll()
            count++
            for (dir in dirs) {
                val x = dir[0] + curr[0]
                val y = dir[1] + curr[1]
                if (x < 0 || y < 0 || x >= r || y >= c || visited[x][y]) {
                    continue
                }
                if (!visited[x][y] && grid[x][y] < currLimit) {
                    q1.offer(intArrayOf(x, y, grid[x][y]))
                } else {
                    q2.offer(intArrayOf(x, y, grid[x][y]))
                }
                visited[x][y] = true
            }
        }
        res[index[i]!!] = count
    }
    return res
}
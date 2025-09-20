private fun toposort(k: Int, matrix: Array<IntArray>): List<Int> {
    val deg = IntArray(k + 1)
    val res: MutableList<Int> = ArrayList()
    val graph: MutableList<MutableList<Int>> = ArrayList()
    for (i in 0 until k) {
        graph.add(ArrayList())
    }
    val queue: Queue<Int> = LinkedList()
    for (a in matrix) {
        val from = a[0]
        val to = a[1]
        graph[from - 1].add(to)
        deg[to]++
    }
    for (i in 1..k) {
        if (deg[i] == 0) {
            queue.offer(i)
            res.add(i)
        }
    }
    while (queue.isNotEmpty()) {
        val node = queue.poll()
        val list: List<Int> = graph[node - 1]
        for (i in list) {
            if (--deg[i] == 0) {
                queue.offer(i)
                res.add(i)
            }
        }
    }
    return res
}
// #Hard #Array #Matrix #Graph #Topological_Sort
// #2023_07_02_Time_706_ms_(100.00%)_Space_65.8_MB_(100.00%)

import java.util.LinkedList
import java.util.Queue

class Solution {
    // Using topological sort to solve this problem
    fun buildMatrix(k: Int, rowConditions: Array<IntArray>, colConditions: Array<IntArray>): Array<IntArray> {
        // First, get the topo-sorted of row and col
        val row = toposort(k, rowConditions)
        val col = toposort(k, colConditions)
        // base case: when the length of row or col is less than k, return empty.
        // That is: there is a loop in established graph
        if (row.size < k || col.size < k) {
            return Array(0) { IntArray(0) }
        }
        val res = Array(k) { IntArray(k) }
        val map: MutableMap<Int, Int> = HashMap()
        for (i in 0 until k) {
            // we record the number corresbonding to each column:
            // [number, column index]
            map[col[i]] = i
        }
        // col: 3 2 1
        // row: 1 3 2
        for (i in 0 until k) {
            // For each row: we have number row.get(i). And we need to know
            // which column we need to assign, which is from map.get(row.get(i))
            // known by map.get()
            res[i][map[row[i]]!!] = row[i]
        }
        return res
    }

    private fun toposort(k: Int, matrix: Array<IntArray>): List<Int> {
        /* GENERATE THIS FUNCTION */
    }
}

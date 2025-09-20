import java.util.*

data class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null)

typealias Node = TreeNode

// https://leetcode.com/problems/increasing-order-search-tree/
class RearrangeTree {
    fun executeRecursive(input: TreeNode?, acc: TreeNode? = null): TreeNode? = when (input) {
        /* GENERATE THIS FUNCTION */
    }

    fun executeIterative(input: TreeNode?): TreeNode? {
        var root: TreeNode? = null
        var current = input
        var last: TreeNode? = null
        val stack = LinkedList<TreeNode>()
        while (current != null || stack.isNotEmpty()) {
            while (current != null) {
                stack.push(current)
                current = current.left
            }
            if (stack.isNotEmpty()) {
                val item = stack.pop()
                TreeNode(item.`val`).let { newNode ->
                    if (last == null) {
                        root = newNode
                        last = newNode
                    } else {
                        last!!.right = newNode
                        last = newNode
                    }
                }
                current = item?.right
            }
        }
        return root
    }
}
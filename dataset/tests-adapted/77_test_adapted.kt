fun main() {
    fun treesEqual(a: TreeNode?, b: TreeNode?): Boolean {
        if (a == null && b == null) return true
        if (a == null || b == null) return false
        return a.`val` == b.`val` && treesEqual(a.left, b.left) && treesEqual(a.right, b.right)
    }

    fun treeToString(node: TreeNode?): String {
        if (node == null) return "null"
        val rightStr = if (node.right != null) " -> ${treeToString(node.right)}" else ""
        return "${node.`val`}$rightStr"
    }

    val tests = listOf(
        Pair(
            TreeNode(5,
                left = TreeNode(3,
                    left = TreeNode(2, left = TreeNode(1)),
                    right = TreeNode(4)),
                right = TreeNode(6,
                    right = TreeNode(8,
                        left = TreeNode(7),
                        right = TreeNode(9)))),
            TreeNode(1,
                right = TreeNode(2,
                    right = TreeNode(3,
                        right = TreeNode(4,
                            right = TreeNode(5,
                                right = TreeNode(6,
                                    right = TreeNode(7,
                                        right = TreeNode(8,
                                            right = TreeNode(9))))))))))
    )

    tests.forEachIndexed { index, (input, expected) ->
        val recursiveOutput = RearrangeTree().executeRecursive(input)
        if (!treesEqual(expected, recursiveOutput)) {
            throw IllegalStateException(
                "Recursive test $index failed.\nExpected: ${treeToString(expected)}\nBut got: ${treeToString(recursiveOutput)}"
            )
        } else {
            println("Valid: recursive index $index output '${treeToString(recursiveOutput)}'")
        }

        val iterativeOutput = RearrangeTree().executeIterative(input)
        if (!treesEqual(expected, iterativeOutput)) {
            throw IllegalStateException(
                "Iterative test $index failed.\nExpected: ${treeToString(expected)}\nBut got: ${treeToString(iterativeOutput)}"
            )
        } else {
            println("Valid: iterative index $index output '${treeToString(iterativeOutput)}'")
        }
    }

    println("All tests passed!")
}

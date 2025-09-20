fun executeRecursive(input: TreeNode?, acc: TreeNode? = null): TreeNode? = when (input) {
    null -> acc
    else -> {
        executeRecursive(input.right, executeRecursive(input.left, acc)?.also {
            var current = it
            while (current.right != null) current = current.right!!
            current.right = TreeNode(input.`val`)
        } ?: TreeNode(input.`val`))
    }
}
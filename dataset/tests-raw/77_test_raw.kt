fun <INPUT, VALUE, OUTPUT> runTests(
    values: List<INPUT>
    , evaluation: (VALUE, OUTPUT) -> Boolean = { v, o -> v == o }
    , valueString: (VALUE) -> String = { it.toString() }
    , outputString: (OUTPUT) -> String = { it.toString() }
    , execution: (INPUT) -> Pair<VALUE, OUTPUT>) {
  values.forEachIndexed { index, input ->
    val (value, output) = execution(input)
    if (evaluation(value, output)) {
      println("Valid: index $index output '${outputString(output)}'")
    } else {
      println("index $index Expected '${valueString(value)}'")
      println(" but instead got '${outputString(output)}'")
    }

  }
}


fun main() {
  runTests(
      listOf(
          Pair(TreeNode(5,
              left = TreeNode(3,
                  left = TreeNode(2, left = TreeNode(1)),
                  right = TreeNode(4)),
              right = TreeNode(6,
                  right = TreeNode(8, left = TreeNode(7), right = TreeNode(9)))),
              TreeNode(1,
                  right = TreeNode(2,
                      right = TreeNode(3,
                          right = TreeNode(4,
                              right = TreeNode(5,
                                  right = TreeNode(6,
                                      right = TreeNode(7,
                                          right = TreeNode(8,
                                              right = TreeNode(9)))))))))
          )
      )
  ) { (input, value) -> Pair(value, RearrangeTree().executeRecursive(input)) }
}

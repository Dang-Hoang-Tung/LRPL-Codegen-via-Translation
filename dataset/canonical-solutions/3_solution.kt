fun doCalculation(expression: String, prioritizeAddition: Boolean = false): Long {
    val maybeParens = parensNoNesting.find(expression)
    return if (maybeParens == null)  doSingleCalculation(expression, prioritizeAddition) else {
        val withoutSurroundingParens = maybeParens.value.drop(1).dropLast(1)
        val replacedWithResult = expression.replaceRange(maybeParens.range, doCalculation(withoutSurroundingParens, prioritizeAddition).toString())
        doCalculation(replacedWithResult, prioritizeAddition)
    }
}
import java.io.File

var hardcodedInput = ""

object InputReader {
    fun getInputAsString(day: Int): String {
        return hardcodedInput
    }

    fun getInputAsList(day: Int): List<String> {
        return hardcodedInput.lines()
    }
}

abstract class Day(dayNumber: Int) {

    // lazy delegate ensures the property gets computed only on first access
    protected val inputList: List<String> by lazy { InputReader.getInputAsList(dayNumber) }
    protected val inputString: String by lazy { InputReader.getInputAsString(dayNumber) }

    abstract fun partOne(): Any

    abstract fun partTwo(): Any
}

class Day18 : Day(18) {

    // 21993583522852
    override fun partOne(): Any {
        return inputList.map { doCalculation(it) }.sum()
    }

    // 122438593522757
    override fun partTwo(): Any {
        return inputList.map { doCalculation(it, true) }.sum()
    }

    fun doCalculation(expression: String, prioritizeAddition: Boolean = false): Long {
        val maybeParens = parensNoNesting.find(expression)
        return if (maybeParens == null)  doSingleCalculation(expression, prioritizeAddition) else {
            val withoutSurroundingParens = maybeParens.value.drop(1).dropLast(1)
            val replacedWithResult = expression.replaceRange(maybeParens.range, doCalculation(withoutSurroundingParens, prioritizeAddition).toString())
            doCalculation(replacedWithResult, prioritizeAddition)
        }
    }

    private fun doSingleCalculation(expression: String, prioritizeAddition: Boolean = false): Long {
        val nextExpr = if (prioritizeAddition) singleExprAdd.find(expression) ?: singleExpr.find(expression)!!
                       else singleExpr.find(expression)!!

        val result = doSingleSum(nextExpr.groupValues.drop(1))
        return if (expression == nextExpr.value) result else {
            val newExpr = expression.replaceRange(nextExpr.range, result.toString())
            return doSingleCalculation(newExpr, prioritizeAddition)
        }
    }

    private fun doSingleSum(parts: List<String>): Long {
        val (x, y) = parts[0].replace("(", "").toLong() to parts[2].replace(")", "").toLong()
        return when (parts[1]) {
            "*" -> x * y
            "+" -> x + y
            else -> throw IllegalArgumentException()
        }
    }

    companion object {
        private val singleExpr = Regex("(\\d+) ([+\\-/*]) (\\d+)")
        private val singleExprAdd = Regex("(\\d+) (\\+) (\\d+)")
        private val parensNoNesting = Regex("(\\([\\d*+ ]+\\))")
    }
}

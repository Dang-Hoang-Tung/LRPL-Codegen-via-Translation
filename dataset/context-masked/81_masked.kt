class Day05(val input: String) {
    fun react(polymerInput: String = input): Int {
        /* GENERATE THIS FUNCTION */
    }

    fun fullyReact(): Int{
        val units = input.toCharArray().distinctBy { it.lowercaseChar() }

        return units.map { testUnit ->  input.filterNot { testUnit.lowercaseChar() == it || testUnit.uppercaseChar() == it } }
            .map { react(it) }
            .min()!!
    }


    private infix fun Char.same(other: Char) : Boolean {
        return when {
            this.isLowerCase() -> this.uppercaseChar() == other
            this.isUpperCase() -> this.lowercaseChar() == other
            else -> false
        }
    }

}

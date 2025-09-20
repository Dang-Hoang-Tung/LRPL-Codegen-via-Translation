class Day05(val input: String) {
    fun react(polymerInput: String = input): Int {
        var polymer = polymerInput
        var index = 0

        while (true) {
            if (index >= polymer.length - 1) break
            if (polymer[index] same polymer[index + 1]) {
                polymer = polymer.removeRange(index..index + 1)
                if (index != 0) index--
            } else {
                index++
            }
        }

        return polymer.length
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

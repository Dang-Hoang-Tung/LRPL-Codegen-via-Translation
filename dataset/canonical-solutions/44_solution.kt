private fun List<String>.parseStacks(): Map<Int, MutableList<Char>> {
    val numberOfStacks = last().split(regex = Regex("\\s")).last { it.isNotBlank() }.toInt()
    val result = (1..numberOfStacks).associateWith { mutableListOf<Char>() }

    reversed().drop(1).forEach {
        it.crates(numberOfStacks).forEachIndexed { index, c ->
            if (c.isLetter()) {
                result[index + 1]?.add(c)
                    ?: throw IndexOutOfBoundsException("Failed to insert $c at index $index into $result")

            }
        }
    }

    return result
}
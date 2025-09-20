fun addToGroup(
    groupedCalories: MutableMap<Int, List<String>>,
    group: MutableList<String>
) {
    groupedCalories[group.sumOf { it.toInt() }] = group
}

fun getGroupedCalories(input: List<String>): MutableMap<Int, List<String>> {
    /* GENERATE THIS FUNCTION */
}

fun part1(input: List<String>): Int {
    val groupedCalories: MutableMap<Int, List<String>> = getGroupedCalories(input)

    return groupedCalories.keys.max()
}

fun part2(input: List<String>): Int {
    val groupedCalories: MutableMap<Int, List<String>> = getGroupedCalories(input)
    val sortedCalories = groupedCalories.keys.sorted().reversed()

    return sortedCalories.take(3).sum()
}

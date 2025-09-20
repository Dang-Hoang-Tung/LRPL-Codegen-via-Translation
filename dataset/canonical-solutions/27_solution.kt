fun getGroupedCalories(input: List<String>): MutableMap<Int, List<String>> {
    val groupedCalories: MutableMap<Int, List<String>> = HashMap()
    var group: MutableList<String> = ArrayList()
    for (calories in input) {
        if (calories.isNotEmpty()) {
            group.add(calories)
        } else {
            addToGroup(groupedCalories, group)
            group = ArrayList()
        }
    }
    if (group.size > 0) {
        addToGroup(groupedCalories, group)
    }
    return groupedCalories
}
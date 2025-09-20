private fun checkTrees(slope: Pair<Int, Int>): Int {
    var trees = 0
    var location = 0 to 0
    while (location.second < input.size) {
        trees += if (input[location.second][location.first] == '#') 1 else 0
        location += slope
    }
    return trees
}
fun findNumbers(input: List<String>): Int{
    var one = 0
    var four = 0
    var seven = 0
    var eight = 0
    for(line in input){
        val output = line.split("|").last().trim().split(" ")
        one += output.count { it.length == 2 }
        four += output.count { it.length == 4 }
        seven += output.count { it.length == 3 }
        eight += output.count { it.length == 7 }
    }
    return one + four + seven + eight
}

fun findOutputSum(input: List<String>): Int{
    var sum = 0
    for (line in input){
        val (patterns, output) = line.split("|").map { it.trim().split(" ") }
        sum += outputValue(patterns, output)
    }
    return sum
}

fun outputValue(patterns: List<String>, output: List<String>): Int {
    /* GENERATE THIS FUNCTION */
}

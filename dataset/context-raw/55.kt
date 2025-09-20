fun main() {
//    fun part1(input: List<String>): Int {
//        return input.size
//    }
//
//    fun part2(input: List<String>): Int {
//        return input.size
//    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    //println(Day04_part1(testInput))
    //println(Day04_part2(testInput))

    val input = readInput("Day04")
    //println(Day04_part1(input))
    println(Day04_part2(input))

}






fun Day04_part1(input: List<String>): Int {

    var count: Int = 0

    for(i in input.indices) {
        val sections = input[i].split(",")
        val first = sections[0].split("-")
        val second = sections[1].split("-")

        if((first[0].toInt() - second[0].toInt() <= 0 && first[1].toInt() - second[1].toInt() >= 0) || (first[0].toInt() - second[0].toInt() >= 0 && first[1].toInt() - second[1].toInt() <= 0)) {
            count++
        }
    }

    return count

}

fun Day04_part2(input: List<String>): Int {

    var count: Int = 0

    for(i in input.indices) {
        val sections = input[i].split(",")
        val first = sections[0].split("-")
        val second = sections[1].split("-")

        if(second[0].toInt() - first[1].toInt() <= 0 && second[1].toInt() - first[0].toInt() >= 0) {
            count++
        }
    }

    return count

}


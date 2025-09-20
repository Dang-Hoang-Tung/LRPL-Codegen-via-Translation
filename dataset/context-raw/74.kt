fun main() {

    fun encryptedStrategyGuide(input: String): List<List<String>> {
        return input.replace(" ", "").split("\n")
            .map { it.lines() }
    }

    fun getShapeWeight(shape: Char): Int {
        if(shape == 'X') {
            return 1 //rock
        }
        if(shape == 'Y') {
            return 2 //paper
        }
        if(shape == 'Z') {
            return 3 //scissors
        }
        return 0
    }

    fun part1(combination: String): Int {
        val pairs = encryptedStrategyGuide(combination)
        var combinedCases = arrayOf<Int>()

        for (i in pairs) {
            if (i.contains("BX") || i.contains("CY") || i.contains("AZ")) {
                combinedCases += (0 + getShapeWeight(i[0][1])) //lose + shape weight
            }
            if (i.contains("AX") || i.contains("BY") || i.contains("CZ")) {
                combinedCases += (3 + getShapeWeight(i[0][1])) //draw + shape weight
            }
            if (i.contains("CX") || i.contains("AY") || i.contains("BZ")) {
                combinedCases += (6 + getShapeWeight(i[0][1])) //win + shape weight
            }
        }
        return combinedCases.sum()
    }


    fun getCounterWeight(pair: String): Int {
        if(pair == "AY" || pair == "BX" || pair == "CZ") {
            return 1 //rock
        }
        if(pair == "AZ" || pair == "BY" || pair == "CX") {
            return 2 //paper
        }
        if(pair == "AX" || pair == "BZ" || pair == "CY") {
            return 3 //scissors
        }
        return 0
    }

    fun part2(combination: String): Int {
        val pairs = encryptedStrategyGuide(combination)
        var combinedCases = arrayOf<Int>()

        for (i in pairs) {
            if (i.contains("AX") || i.contains("BX") || i.contains("CX")) {
                combinedCases += (0 + getCounterWeight(i[0])) //counter shape to lose
            }
            if (i.contains("AY") || i.contains("BY") || i.contains("CY")) {
                combinedCases += (3 + getCounterWeight(i[0])) //counter shape to draw
            }
            if (i.contains("AZ") || i.contains("BZ") || i.contains("CZ")) {
                combinedCases += (6 + getCounterWeight(i[0])) //counter shape to win
            }
        }
        return combinedCases.sum()
    }

        //val testInput = readInput("esg")
        //check(combinationOfCases(testInput) == 15)
        //check(indicatedCase(testInput) == 12)

        val input = readInput("esg")
        println(part1(input))
        println(part2(input))
    }
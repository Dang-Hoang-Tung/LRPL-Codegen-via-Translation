fun magicRingSolutionsOptimised(n: Int, s: Int): List<String> {
    val solutions = mutableListOf<String>()
    val allDigits = (1..n * 2)
    val remainingDigits = allDigits.toMutableSet()
    val ringNodes = IntArray(n)
    val externalNodes = IntArray(n)

    fun nextRingNodeOptimised(i: Int) {
        if (i == n - 1) {
            externalNodes[i] = s - ringNodes[i] - ringNodes[0]
            if (
                externalNodes[i] in remainingDigits &&
                externalNodes[0] == externalNodes.minOrNull()
            ) {
                var solution1 = ""
                var solution2 = ""
                for (j in 0 until n) {
                    solution1 += "${externalNodes[j]}${ringNodes[j]}${ringNodes[(j+1)%n]}"
                    solution2 += "${externalNodes[(n-j)%n]}${ringNodes[(n-j+1)%n]}${ringNodes[(n-j)%n]}"
                }
                solutions.add(solution1)
                solutions.add(solution2)
            }
        } else {
            val searchRange = if (i == 0) (ringNodes[0] + 1)..(n * 2) else allDigits
            for (digit in searchRange) {
                if (digit !in remainingDigits) continue
                val nextExternal = s - ringNodes[i] - digit
                if (nextExternal == digit || nextExternal !in remainingDigits) continue
                ringNodes[i+1] = digit
                externalNodes[i] = nextExternal
                val justUsed = setOf(digit, nextExternal)
                remainingDigits.removeAll(justUsed)
                nextRingNodeOptimised(i + 1)
                remainingDigits.addAll(justUsed)
            }
        }
    }

    for (digit in 2 until n * 2) {
        ringNodes[0] = digit
        remainingDigits.remove(digit)
        nextRingNodeOptimised(0)
        remainingDigits.clear()
        remainingDigits.addAll(allDigits.toMutableSet())
    }
    return solutions.sorted()
}
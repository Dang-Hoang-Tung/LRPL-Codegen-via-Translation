val testInput = """
32T3K 765
T55J5 684
KK677 28
KTJJT 220
QQQJA 483
""".trimIndent().split("\n")

// test if implementation meets criteria from the description, like:
val testValue = part1(testInput)
println(testValue)
check(testValue == 6440L)

println(part2(testInput))

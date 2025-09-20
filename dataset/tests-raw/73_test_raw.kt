val testInput = listOf(
    "498,4 -> 498,6 -> 496,6\n",
    "503,4 -> 502,4 -> 502,9 -> 494,9\n",
)

check(part1(testInput) == 24)
check(part2(testInput) == 93)

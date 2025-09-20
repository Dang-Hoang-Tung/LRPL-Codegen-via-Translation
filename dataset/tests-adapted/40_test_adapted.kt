fun main() {
  val day = Day8()

  // --- testPart1 ---
  run {
    val input = """
      LLR

      AAA = (BBB, BBB)
      BBB = (AAA, ZZZ)
      ZZZ = (ZZZ, ZZZ)
    """.trimIndent()
    val result = day.part1(day.parseInput(input))
    if (result != 6) {
      throw RuntimeException("testPart1 failed: expected 6, got $result")
    }
  }

  // --- testPart2 ---
  run {
    val input = """
      LR

      11A = (11B, XXX)
      11B = (XXX, 11Z)
      11Z = (11B, XXX)
      22A = (22B, XXX)
      22B = (22C, 22C)
      22C = (22Z, 22Z)
      22Z = (22B, 22B)
      XXX = (XXX, XXX)
    """.trimIndent()
    val result = day.part2(day.parseInput(input))
    if (result != 6L) {
      throw RuntimeException("testPart2 failed: expected 6, got $result")
    }
  }

  // --- testLcm ---
  run {
    val result1 = lcm(listOf(1L, 2L, 8L, 3L))
    if (result1 != 24L) {
      throw RuntimeException("testLcm (case1) failed: expected 24, got $result1")
    }

    val result2 = lcm(listOf(2L, 7L, 3L, 9L, 4L))
    if (result2 != 252L) {
      throw RuntimeException("testLcm (case2) failed: expected 252, got $result2")
    }
  }

  println("All tests passed!")
}

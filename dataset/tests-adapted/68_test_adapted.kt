fun test() {
    val testInputString = """
        $ cd /
        $ ls
        dir a
        14848514 b.txt
        8504156 c.dat
        dir d
        $ cd a
        $ ls
        dir e
        29116 f
        2557 g
        62596 h.lst
        $ cd e
        $ ls
        584 i
        $ cd ..
        $ cd ..
        $ cd d
        $ ls
        4060174 j
        8033020 d.log
        5626152 d.ext
        7214296 k
    """.trimIndent()

    val testInput = testInputString.lines()

    fun assertEquals(expected: Any?, actual: Any?) {
        if (expected != actual) {
            throw IllegalStateException("Test failed: expected=$expected, actual=$actual")
        }
    }

    assertEquals(95437L, part1(testInput))
    assertEquals(0, part2(testInput))

    println("All tests passed!")
}

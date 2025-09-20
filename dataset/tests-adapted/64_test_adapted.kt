fun main() {
    fun assertEqual(actual: IntArray, expected: IntArray) {
        if (actual.size != expected.size) {
            throw IllegalStateException(
                "Assertion failed: size mismatch. Expected=${expected.contentToString()}, Actual=${actual.contentToString()}"
            )
        }
        for (i in actual.indices) {
            if (actual[i] != expected[i]) {
                throw IllegalStateException(
                    "Assertion failed at index $i. Expected=${expected.contentToString()}, Actual=${actual.contentToString()}"
                )
            }
        }
    }

    val strategy = SmallestSufficientTeamDFS()

    // Test case 1
    run {
        val reqSkills = arrayOf("java", "nodejs", "reactjs")
        val people = listOf(
            listOf("java"),
            listOf("nodejs"),
            listOf("nodejs", "reactjs"),
        )
        val expected = intArrayOf(0, 2)
        val actual = strategy.invoke(reqSkills, people)
        assertEqual(actual, expected)
    }

    val strategy2 = SmallestSufficientTeamDFS()

    // Test case 2
    run {
        val reqSkills = arrayOf("algorithms", "math", "java", "reactjs", "csharp", "aws")
        val people = listOf(
            listOf("algorithms", "math", "java"),
            listOf("algorithms", "math", "reactjs"),
            listOf("java", "csharp", "aws"),
            listOf("reactjs", "csharp"),
            listOf("csharp", "math"),
            listOf("aws", "java"),
        )
        val expected = intArrayOf(1, 2)
        val actual = strategy2.invoke(reqSkills, people)
        assertEqual(actual, expected)
    }

    println("All tests passed!")
}

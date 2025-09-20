fun main() {
    val tool = Magic5GonRing()

    fun assertEquals(expected: Any, actual: Any) {
        if (expected != actual) {
            throw Error("assertEquals failed:\nExpected: $expected\nActual:   $actual")
        }
    }

    fun <T> assertContentEquals(expected: List<T>, actual: List<T>) {
        if (expected.size != actual.size || expected != actual) {
            throw Error("assertContentEquals failed:\nExpected: $expected\nActual:   $actual")
        }
    }

    // HR Problem correct for magic 3-gon ring
    run {
        val n = 3
        val expected = listOf(
            listOf("423531612", "432621513"),
            listOf("235451613", "253631415"),
            listOf("146362524", "164542326"),
            listOf("156264345", "165354246")
        )
        for (s in 9..12) {
            assertContentEquals(expected[s-9], tool.magicRingSolutions(n, s))
            assertContentEquals(expected[s-9], tool.magicRingSolutionsImproved(n, s))
            assertContentEquals(expected[s-9], tool.magicRingSolutionsOptimised(n, s))
        }
    }

    // HR Problem correct for magic 4-gon ring
    run {
        val n = 4
        val expected = listOf(
            listOf("426561813732", "462723831516"),
            listOf("256364841715", "265751814346", "328481715652", "382625751418"),
            listOf("158284743635", "185653734248", "248581617374", "284347671518"),
            listOf("168483537276", "186267573438"),
            emptyList()
        )
        for (s in 12..16) {
            assertContentEquals(expected[s-12], tool.magicRingSolutions(n, s))
            assertContentEquals(expected[s-12], tool.magicRingSolutionsImproved(n, s))
            assertContentEquals(expected[s-12], tool.magicRingSolutionsOptimised(n, s))
        }
    }

    // HR Problem correct for magic 6-gon ring
    run {
        val n = 6
        val expected = listOf(
            listOf(
                "467872122393511511016", "467971111510521223836", "476106111159531232827",
                "476863123210251151917", "629791111585410431232", "692122310348451151719"
            ),
            listOf("3105115212246489817110", "3510710191868412421125"),
            listOf(
                "1117107282969412435311", "1117973123410458562611", "1711211686510541243937",
                "1711511312346498921027", "2116126110184879735311", "2125115393747810816112",
                "2125658108111179734312", "2512412393711711018685", "2512612110184879731135",
                "2611511393747810811216", "2896941243531171111018", "2981081711151131234649"
            )
        )
        for (s in 17..19) {
            assertContentEquals(expected[s-17], tool.magicRingSolutions(n, s))
            assertContentEquals(expected[s-17], tool.magicRingSolutionsImproved(n, s))
            assertContentEquals(expected[s-17], tool.magicRingSolutionsOptimised(n, s))
        }
    }

    // PE problem correct
    run {
        val expected = "6531031914842725"
        assertEquals(expected, tool.maxMagic5GonSolution())
    }

    println("All tests passed!")
}

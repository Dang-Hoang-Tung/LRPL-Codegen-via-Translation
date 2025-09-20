import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

input = """
A Y
B X
C Z
""".trimIndent().lines()

internal class RockPaperScissorsTest {
    @Test
    fun part1() {
        val rps = RockPaperScissors(input)
        assertEquals(15, rps.part1())
    }

    @Test
    fun part2() {
        val rps = RockPaperScissors(input)
        assertEquals(12, rps.part2())
    }
}

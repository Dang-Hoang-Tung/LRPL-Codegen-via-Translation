import org.junit.Test
import org.junit.Assert.*

input = "foo"

class Day05Test {

    @Test
    fun react() {
        val sample = "dabAcCaCBAcCcaDA"
        assertEquals("dabCBAcaDA".length, Day05(sample).react())
        println(Day05(input).react())
    }

    @Test
    fun fullyReact() {
        val sample = "dabAcCaCBAcCcaDA"
        assertEquals("daDA".length, Day05(sample).fullyReact())
        println(Day05(input).fullyReact())
    }
}

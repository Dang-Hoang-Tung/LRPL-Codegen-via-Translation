import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test

class P42861Test {
    val sut = P42861()

    @Test
    fun `example 1`() {
        assertThat(
            sut.solution(
                4, arrayOf(
                    intArrayOf(0, 1, 1),
                    intArrayOf(0, 2, 2),
                    intArrayOf(1, 2, 5),
                    intArrayOf(1, 3, 1),
                    intArrayOf(2, 3, 8)
                )
            ), `is`(4)
        )
    }

    @Test
    fun `example 2`() {
        assertThat(
            sut.solution(
                7, arrayOf(
                    intArrayOf(2, 3, 7),
                    intArrayOf(3, 6, 13),
                    intArrayOf(3, 5, 23),
                    intArrayOf(5, 6, 25),
                    intArrayOf(0, 1, 29),
                    intArrayOf(1, 5, 34),
                    intArrayOf(1, 2, 35),
                    intArrayOf(4, 5, 53),
                    intArrayOf(0, 4, 75)
                )
            ), `is`(159)
        )
    }

    @Test
    fun `example 3`() {
        assertThat(
            sut.solution(
                5, arrayOf(
                    intArrayOf(0, 1, 5),
                    intArrayOf(1, 2, 3),
                    intArrayOf(2, 3, 3),
                    intArrayOf(3, 1, 2),
                    intArrayOf(3, 0, 4),
                    intArrayOf(2, 4, 6),
                    intArrayOf(4, 0, 7)
                )
            ), `is`(15)
        )
    }


}

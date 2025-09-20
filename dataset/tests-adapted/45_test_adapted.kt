fun main() {
    fun assertEquals(expected: Int, actual: Int) {
        if (expected != actual) {
            throw IllegalStateException("Assertion failed: expected=$expected, actual=$actual")
        }
    }

    // Equivalent to guessNumberTest()
    assertEquals(1, NumberGuessingGame(1).guessNumber(1))
    assertEquals(6, NumberGuessingGame(6).guessNumber(10))
    assertEquals(699, NumberGuessingGame(699).guessNumber(1400))
    assertEquals(3, NumberGuessingGame(3).guessNumber(1400))

    println("All tests passed!")
}

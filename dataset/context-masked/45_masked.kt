/**
 * I pick a number from 1 to n. You have to guess which number I picked. Every time you guess wrong, I'll tell you whether the number is higher or lower.
 * You call a pre-defined API guess(int num) which returns 3 possible results (-1, 1, or 0):
 */
internal data class NumberGuessingGame(val luckyNumber: Int) {
    /**
     * @return 0 if the given number is equal to [luckyNumber]; -1 if [luckyNumber] is lower than the given number;
     * 1 if [luckyNumber] is higher than the given number.
     */
    private fun guess(guessedNumber: Int): Int {
        return when {
            guessedNumber == luckyNumber -> 0
            guessedNumber > luckyNumber -> -1
            else -> 1
        }
    }

    /**
     * Guesses the lucky number using binary search and the given maximum number. The limit for guessing is 1 to [maxNumber] (inclusive).
     * @return the guessed number.
     */
    fun guessNumber(maxNumber: Int): Int {
        /* GENERATE THIS FUNCTION */
    }
}

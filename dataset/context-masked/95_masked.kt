enum class HandTypes {
    FIVE_KIND, FOUR_KIND, FULL_HOUSE, THREE_KIND, TWO_PAIR, ONE_PAIR, HIGH_CARD
}

val scores = "23456789TJQKA".mapIndexed { index, c -> c to index }.toMap()
val jScore = scores['J']!!

fun typeForHand(cards: String): HandTypes {
    /* GENERATE THIS FUNCTION */
}

fun wildTypeForHand(cards: String): HandTypes {
    val counts = cards.groupingBy { it }.eachCount()
    val jCount = counts['J'] ?: 0
    return if (jCount in 1..4) {
        val highest = (counts - 'J').entries.maxByOrNull { it.value }!!.key
        typeForHand(cards.replace('J', highest))
    } else {
        typeForHand(cards)
    }
}

fun String.asListOfScores() = map { scores[it]!! }
fun sortHands(a: String, b: String) = a.asListOfScores().zip(b.asListOfScores()).map { compareValues(it.first, it.second) }.first { it != 0 }

class Hand(val cards: String, val bid: Long): Comparable<Hand> {
    val type = typeForHand(cards)

    val sortScore = cards.asListOfScores()
        .fold(0) { acc, x -> (acc * 16) + x}

    override fun compareTo(other: Hand): Int = (compareByDescending<Hand> { it.type }.thenBy { it.sortScore }).compare(this, other)
    override fun toString(): String {
        return "Hand(cards='$cards', bid=$bid, type=$type)"
    }
}

class Hand2(val cards: String, val bid: Long): Comparable<Hand2> {
    val type = wildTypeForHand(cards)

    val sortScore = cards.asListOfScores()
        .map { if (it == jScore) { 0 } else { it + 1 } }
        .fold(0) { acc, x -> (acc * 16) + x}

    override fun compareTo(other: Hand2): Int = (compareByDescending<Hand2> { it.type }.thenBy { it.sortScore }).compare(this, other)
    override fun toString(): String {
        return "Hand(cards='$cards', bid=$bid, type=$type)"
    }
}

fun part1(input: List<String>): Long {
    val hands = input.map { Hand(it.substringBefore(' '), it.substringAfter(' ').toLong()) }
    return hands
        .sorted()
        .mapIndexed { index, hand -> index + 1 to hand.bid }
        .onEach { println(it) }
        .sumOf { it.first * it.second }
}

fun part2(input: List<String>): Long {
    val hands = input.map { Hand2(it.substringBefore(' '), it.substringAfter(' ').toLong()) }
    return hands
        .sorted()
        .mapIndexed { index, hand -> index + 1 to hand.bid }
        .onEach { println(it) }
        .sumOf { it.first * it.second }
}

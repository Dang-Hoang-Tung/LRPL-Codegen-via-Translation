fun typeForHand(cards: String): HandTypes {
    val counts = cards.groupingBy { it }.eachCount().values.sortedDescending()
    if (counts[0] == 5) { return HandTypes.FIVE_KIND }
    val (c1, c2) = counts
    return if (c1 == 4) { HandTypes.FOUR_KIND }
    else if (c1 == 3 && c2 == 2) { HandTypes.FULL_HOUSE }
    else if (c1 == 3) { HandTypes.THREE_KIND }
    else if (c1 == 2 && c2 == 2) { HandTypes.TWO_PAIR }
    else if (c1 == 2) { HandTypes.ONE_PAIR }
    else HandTypes.HIGH_CARD
}
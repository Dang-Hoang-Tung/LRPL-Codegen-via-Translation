/**
 * Determines the type of poker hand represented by the given cards.
 *
 * Groups the characters in the input string to count occurrences of each rank,
 * sorts these counts in descending order, and applies poker hand classification
 * rules. The logic checks for the highest-ranking hands first (five of a kind,
 * four of a kind, full house, etc.) and falls back to lower-ranking ones until
 * identifying the correct type.
 *
 * @param cards A string of exactly 5 characters, each representing a card rank (e.g., "AKQJT").
 * @return The corresponding [HandTypes] enum value that best describes the hand.
 */
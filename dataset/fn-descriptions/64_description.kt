/**
 * Recursive backtracking search to find the smallest sufficient team.
 *
 * Explores all combinations of people to cover the required skills by representing
 * skills as bitmasks. At each step, it checks if all skills are covered, prunes
 * suboptimal solutions, and tries adding people who can cover the next uncovered skill.
 * Uses backtracking to explore and retract choices.
 *
 * @param cur current bitmask of covered skills
 * @param pe array where each element is a bitmask representing a person's skills
 * @param onesol current partial team (list of indices of selected people)
 * @param n total number of required skills
 * @return nothing directly; updates the global `sol` with the smallest team found
 */
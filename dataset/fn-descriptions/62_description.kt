/**
 * Extracts all contiguous numeric sequences from the schematic grid.
 *
 * Iterates row by row through the grid, detecting digits that have not
 * yet been grouped into a number. For each starting digit, it follows
 * rightward neighbours as long as they are digits, building the full
 * number string and collecting the corresponding grid points. Each
 * discovered number is stored along with the list of points that form
 * it. Numbers are not revisited once included in a sequence.
 *
 * @return a list of pairs, where each pair contains the integer value
 *         of the number found and the ordered list of points that make
 *         up its digits in the grid.
 */
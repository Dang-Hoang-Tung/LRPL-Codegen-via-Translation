/**
 * Splits the list into sublists whenever an element matches the given marker condition.
 *
 * Iterates through the list, starting a new sublist each time the predicate `isMarker`
 * returns true for an element. Elements matching the marker are not included in the
 * resulting sublists. The last segment after the final marker is also added.
 *
 * @param isMarker a predicate function that determines whether an element is a split marker.
 * @return a list of sublists, each containing consecutive elements between markers.
 */
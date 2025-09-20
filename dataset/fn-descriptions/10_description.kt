/**
 * Updates the guard state based on a single log line.
 *
 * Parses the input line to detect whether a guard begins a shift, falls asleep,
 * or wakes up, and updates the current state accordingly. The function uses
 * regular expressions to match the event type and extracts the relevant guard
 * ID or minute value to update the state. If the line does not match any known
 * pattern, an exception is thrown.
 *
 * @param status the current guard state, containing the active guard, nap start time, and recorded naps
 * @param line a log entry string describing a guard's action
 * @return a new [State] reflecting the changes implied by the log line
 */
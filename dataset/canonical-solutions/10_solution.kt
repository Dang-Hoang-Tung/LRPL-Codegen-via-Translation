fun processLine(status: State, line: String): State = when {
    line.matches(beginShiftRE) -> beginShiftRE.find(line)!!.intMatch().run(status::beginShift)
    line.matches(fallAsleepRE) -> fallAsleepRE.find(line)!!.intMatch().run(status::fallAsleep)
    line.matches(wakesUpRE) -> wakesUpRE.find(line)!!.intMatch().run(status::wakeUp)
    else -> throw IllegalArgumentException("Failed to parse: $line")
}
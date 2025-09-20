private fun parsePacket(packetString: String, index: Int = 1): Pair<Packet, Int> {
    var buffer = ""
    var i = index
    val packets = mutableListOf<Packet>()
    // when we hit the close bracket, this parse function is done
    while (packetString[i] != ']') {
        if (packetString[i] == '[') {
            // we are opening a new sub packet - recursively call this method
            val (p, newIndex) = parsePacket(packetString, i+1)
            packets.add(p)
            i = newIndex
            continue
        }
        if (packetString[i] == ',') {
            // On a comma, move to the next item in the list (clear the buffer if necessary)
            if (buffer.isNotEmpty()) {
                packets.add(Packet(buffer.toInt(), null))
                buffer = ""
            }
            i++
            continue
        }
        // Numbers are stored in the buffer (as multi digit numbers are valid)
        buffer += packetString[i]
        i++
    }
    if (buffer.isNotEmpty()) {
        packets.add(Packet(buffer.toInt(), null))
    }
    return Pair(Packet(null, packets), i + 1)
}
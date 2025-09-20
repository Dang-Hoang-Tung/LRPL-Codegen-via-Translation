fun react(polymerInput: String = input): Int {
    var polymer = polymerInput
    var index = 0

    while (true) {
        if (index >= polymer.length - 1) break
        if (polymer[index] same polymer[index + 1]) {
            polymer = polymer.removeRange(index..index + 1)
            if (index != 0) index--
        } else {
            index++
        }
    }

    return polymer.length
}
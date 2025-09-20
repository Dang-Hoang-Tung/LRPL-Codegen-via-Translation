fun searchWord(word: String, index: Int = 0): Boolean {
    val letter = word.getOrNull(index) ?: return true
    if (letter == '.') { // wildcard
        // Ignore this and try to find any other node that matches next character
        return trieMap.values.map {
            it.searchWord(word, index + 1)
        }.any { it }
    } else {
        val nextTrie = trieMap[letter] ?: return false
        return nextTrie.searchWord(word, index + 1)
    }
}
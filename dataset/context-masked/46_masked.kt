/**
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 * Your data structure should implement two methods
 * * `addWord(word)`- Adds word to the data structure
 * * `searchWorld(word)`- Returns true if there is any string in the data structure that matches word. Word may contain dots where a dot can be matched with any letter (a dot represents a wildcard).
 */
class Trie {
    var value: Char? = null

    private val trieMap: MutableMap<Char, Trie> = mutableMapOf()

    fun addWord(word: String, index: Int = 0) {
        val letter = word.getOrNull(index) ?: return
        if (letter !in trieMap) {
            val newTrie = Trie()
            trieMap[letter] = newTrie
            newTrie.value = letter
            newTrie.addWord(word, index + 1)
        } else {
            val trie = trieMap[letter]!!
            trie.addWord(word, index + 1)
        }
    }

    override fun toString(): String {
        return "Trie($value, ${trieMap.values})"
    }

    private fun depthFirstTraversal(trie: Trie, current: String, word: MutableList<String>) {
        if (trie.trieMap.isEmpty()) {
            word.add(current)
        }
        trie.trieMap.forEach { (k, v) ->
            depthFirstTraversal(v, current + k, word)
        }
    }

    fun searchWord(word: String, index: Int = 0): Boolean {
        /* GENERATE THIS FUNCTION */
    }

    fun branches(): List<String> {
        val words = mutableListOf<String>()
        depthFirstTraversal(this, "", words)
        println(words)
        return words
    }
}

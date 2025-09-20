fun main() {
    run {
        val trie = Trie()
        trie.addWord("hello")
        trie.addWord("word")
        trie.addWord("woke")
        trie.addWord("world")

        assertTrue { trie.searchWord("hello") }
        assertTrue { trie.searchWord("word") }
        assertFalse { trie.searchWord("worry") }
        assertTrue { trie.searchWord("wo.d") }
        assertTrue { trie.searchWord("wor.d") }

        trie.addWord("wore")
        trie.addWord("wop")
        trie.addWord("won")
        trie.addWord("worst")

        assertTrue { trie.searchWord("wor.t") }
        assertFalse { trie.searchWord("wor.ts") }
        assertFalse { trie.searchWord("worm") }
        trie.addWord("worm")
        assertTrue { trie.searchWord("worm") }
        assertTrue { trie.searchWord("w.rm") }
        assertTrue { trie.searchWord("w..m") }
        assertTrue { trie.searchWord("...m") }
        assertFalse { trie.searchWord("...ms") }
        assertTrue { trie.searchWord("w...") }
    }

    run {
        val trie = Trie()
        trie.addWord("egg")
        trie.addWord("eggplant")
        trie.addWord("eggshell")
        trie.addWord("elephant")
        trie.addWord("eleanor")
        trie.addWord("eleven")
        trie.addWord("elegant")
        trie.addWord("evil")


        assertTrue { trie.searchWord("egg") }
        assertTrue { trie.searchWord("eg.") }
        assertTrue { trie.searchWord("eg.p.a.t") }
        assertTrue { trie.searchWord("elep.a.t") }
        assertFalse { trie.searchWord("elope") }
        assertFalse { trie.searchWord("el.phat") }
        assertFalse { trie.searchWord("elev.ns") }
        assertFalse { trie.searchWord("elevens") }
        assertFalse { trie.searchWord("eleventh") }
        assertFalse { trie.searchWord("eleven.") }

        trie.addWord("watch")
        trie.addWord("witch")
        trie.addWord("with")
        trie.addWord("without")
        trie.addWord("withe")
        trie.addWord("wither")
        trie.addWord("wit")
        trie.addWord("withering")
        trie.branches()
    }
}

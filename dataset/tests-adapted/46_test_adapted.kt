fun main() {
    fun assertTrue(condition: Boolean, message: String = "Expected true but got false") {
        if (!condition) throw Error(message)
    }

    fun assertFalse(condition: Boolean, message: String = "Expected false but got true") {
        if (condition) throw Error(message)
    }

    run {
        val trie = Trie()
        trie.addWord("hello")
        trie.addWord("word")
        trie.addWord("woke")
        trie.addWord("world")

        assertTrue(trie.searchWord("hello"), "Failed: hello should exist")
        assertTrue(trie.searchWord("word"), "Failed: word should exist")
        assertFalse(trie.searchWord("worry"), "Failed: worry should not exist")
        assertTrue(trie.searchWord("wo.d"), "Failed: wo.d should match woke/word/world")
        assertTrue(trie.searchWord("wor.d"), "Failed: wor.d should match world")

        trie.addWord("wore")
        trie.addWord("wop")
        trie.addWord("won")
        trie.addWord("worst")

        assertTrue(trie.searchWord("wor.t"), "Failed: wor.t should match worst")
        assertFalse(trie.searchWord("wor.ts"), "Failed: wor.ts should not exist")
        assertFalse(trie.searchWord("worm"), "Failed: worm should not exist before add")
        trie.addWord("worm")
        assertTrue(trie.searchWord("worm"), "Failed: worm should exist after add")
        assertTrue(trie.searchWord("w.rm"), "Failed: w.rm should match worm")
        assertTrue(trie.searchWord("w..m"), "Failed: w..m should match worm")
        assertTrue(trie.searchWord("...m"), "Failed: ...m should match worm")
        assertFalse(trie.searchWord("...ms"), "Failed: ...ms should not exist")
        assertTrue(trie.searchWord("w..."), "Failed: w... should match wore/worm/won/etc")
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

        assertTrue(trie.searchWord("egg"), "Failed: egg should exist")
        assertTrue(trie.searchWord("eg."), "Failed: eg. should match egg")
        assertTrue(trie.searchWord("eg.p.a.t"), "Failed: eg.p.a.t should match eggplant")
        assertTrue(trie.searchWord("elep.a.t"), "Failed: elep.a.t should match elephant")
        assertFalse(trie.searchWord("elope"), "Failed: elope should not exist")
        assertFalse(trie.searchWord("el.phat"), "Failed: el.phat should not exist")
        assertFalse(trie.searchWord("elev.ns"), "Failed: elev.ns should not exist")
        assertFalse(trie.searchWord("elevens"), "Failed: elevens should not exist")
        assertFalse(trie.searchWord("eleventh"), "Failed: eleventh should not exist")
        assertFalse(trie.searchWord("eleven."), "Failed: eleven. should not exist")

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

    println("All tests passed.")
}

package org.mingtaoz.a9.string;

import static org.truth0.Truth.ASSERT;

import org.junit.Before;
import org.junit.Test;
import org.mingtaoz.a9.string.Trie;

public class TrieTest {

    private Trie sut;

    @Before
    public void setup() {
        sut = new Trie();
    }

    @Test
    public void testTrie1() {
        sut.insert("a");
        ASSERT.that(sut.search("a")).isTrue();
        ASSERT.that(sut.startsWith("a")).isTrue();
    }

}

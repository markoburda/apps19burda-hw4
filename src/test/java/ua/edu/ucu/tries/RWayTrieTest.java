package ua.edu.ucu.tries;

import org.junit.Test;

import static org.junit.Assert.*;

public class RWayTrieTest {

    Tuple[] tuples = {new Tuple("the", 3), new Tuple("there", 5),
            new Tuple("answer", 6), new Tuple("any", 3),
            new Tuple("by", 2), new Tuple("bye", 3),
            new Tuple("their", 5)};

    String[] output = {"Not present in trie", "Present in trie"};

    Trie testTrie = new RWayTrie();

    @Test
    public void add_contains() {
        testTrie.add(tuples[0]);
        testTrie.add(tuples[2]);
        testTrie.add(tuples[5]);
        assertEquals(testTrie.contains("the"), true);
        assertEquals(testTrie.contains("there"), false);
        assertEquals(testTrie.contains("answer"), true);
        assertEquals(testTrie.contains("any"), false);
        assertEquals(testTrie.contains("by"), false);
        assertEquals(testTrie.contains("bye"), true);
    }


}
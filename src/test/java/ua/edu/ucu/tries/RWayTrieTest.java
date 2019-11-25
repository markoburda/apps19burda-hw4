package ua.edu.ucu.tries;

import org.junit.Test;
import ua.edu.ucu.queue.LinkedList;
import ua.edu.ucu.queue.Queue;

import static org.junit.Assert.*;

public class RWayTrieTest {

    Tuple[] tuples = {new Tuple("the", 3), new Tuple("there", 5),
            new Tuple("answer", 6), new Tuple("any", 3),
            new Tuple("by", 2), new Tuple("bye", 3),
            new Tuple("their", 5)};

    String[] output = {"Not present in trie", "Present in trie"};

    Trie testTrie = new RWayTrie();

    @Test
    public void test_all() {
        testTrie.add(tuples[0]);
        testTrie.add(tuples[1]);
        testTrie.add(tuples[2]);
        testTrie.add(tuples[5]);
        testTrie.add(tuples[3]);
        testTrie.add(tuples[4]);
        testTrie.delete("any");
        testTrie.delete("the");
        testTrie.delete("there");
        assertEquals(testTrie.contains("the"), false);
        assertEquals(testTrie.contains("there"), false);
        assertEquals(testTrie.contains("answer"), true);
        assertEquals(testTrie.contains("any"), false);
        assertEquals(testTrie.contains("by"), true);
        assertEquals(testTrie.contains("bye"), true);
    }

    @Test
    public void testLinkedList(){
        LinkedList list = new LinkedList();
        list.addFirst(70);
        list.addFirst(25);
        list.addLast(96);
        list.removeLast();
    }

    @Test
    public void testQueue(){
        Queue testQueue = new Queue();
        testQueue.enqueue("a");
        assertEquals(testQueue.peek(), "a");
        testQueue.enqueue("b");
        testQueue.dequeue();
        assertEquals(testQueue.peek(), "b");
        testQueue.enqueue("c");
        testQueue.dequeue();
        assertEquals(testQueue.peek(), "c");
        System.out.println(testQueue.toString());
    }
}
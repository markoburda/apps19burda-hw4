package ua.edu.ucu.tries;

import ua.edu.ucu.queue.Queue;

import java.util.Arrays;

public class RWayTrie implements Trie{
    static final int R = 26;
    private Node root;
    private int size;

    public RWayTrie(){
        Tuple rootValue = new Tuple(null, 0);
        this.root = new Node(rootValue);
        this.size = 0;
    }

    static class Node {
        int weight;
        Node[] links = new Node[R];

        Node(Tuple t) {
            this.weight = 0;
            for (int i = 0; i < R; i++)
                links[i] = null;
        }
    }

    @Override
    public void add(Tuple t) {
        int level;
        int index;
        Node currentNode = root;
        for (level = 0; level < t.weight; level++) {
            index = t.term.toLowerCase().charAt(level) - 'a';
            if (currentNode.links[index] == null)
                currentNode.links[index] = new Node(t);
            currentNode = currentNode.links[index];
        }
        currentNode.weight = t.weight;
        this.size++;
    }

    public Node getLeaf(String word){
        int level;
        int index;
        Node currentNode = root;

        for (level = 0; level < word.length(); level++) {
            index = word.toLowerCase().charAt(level) - 'a';
            if (currentNode.links[index] == null)
                return null;
            currentNode = currentNode.links[index];
        }
        if(currentNode.weight > 0)
            return currentNode;
        return null;
    }

    @Override
    public boolean contains(String word) {
        return this.getLeaf(word) != null;
    }

    @Override
    public boolean delete(String word) {
        Node res = this.getLeaf(word);
        if(this.getLeaf(word) == null)
            return false;
        res.weight = 0;
        this.size--;
        return true;
    }

    @Override
    public Iterable<String> words() {
        Node currentNode = this.root;
        Queue queue = new Queue();
        for (int index = 0; index < R; index++) {
            if (currentNode.links[index] != null) {
                queue.enqueue(Integer.toString(index));
            }
        }
        return Arrays.stream(queue.toArray()).iterator();
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int size() {
        return this.size;
    }
}
package ua.edu.ucu.queue;

public class Queue extends LinkedList{
    public Queue(){
    }

    public void enqueue(String word) {
        this.addFirst(word);
    }

    public void dequeue()
    {
        this.removeLast();
    }

    public Object peek(){
        return this.getLast();
    }
}

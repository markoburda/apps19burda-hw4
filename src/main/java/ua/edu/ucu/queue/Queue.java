package ua.edu.ucu.queue;

public class Queue extends LinkedList{
    public Queue(){
    }

    public void enqueue(Object e) {
        this.addFirst(e);
    }

    public Object dequeue()
    {
        return this.removeLast();
    }

    public Object peek(){
        return this.getLast();
    }

    public String[] toArray(){
        return this.toArray();
    }

    public boolean isEmpty(){
        return getLast() == null;
    }
}

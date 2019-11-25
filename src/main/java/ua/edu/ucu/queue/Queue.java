package ua.edu.ucu.queue;

public class Queue extends LinkedList{
    Node front;
    Node rear;

    public Queue(){
        this.front = this.rear = null;
    }

    public void enqueue(String word) {
        Node currentNode = new Node(word);
//        if (this.rear == null)
//            this.front = this.rear = currentNode;
//        else {
//            this.rear.next = currentNode;
//            this.rear = currentNode;
//        }
        currentNode.next = this.rear;
        this.rear = currentNode;
    }

    public void dequeue()
    {
        // If queue is empty, return NULL.
//        if (this.front != null) {
//            Node currentNode = this.front;
//            this.front = this.front.next;
//        }
//        if (this.front == null)
//            this.rear  = null;
        Node currentNode = this.front;
        this.front = null;
    }

//    public String peek(){
//        return this.rear;
//    }
}

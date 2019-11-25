package ua.edu.ucu.queue;

public class LinkedList {
    private int size;
    private Node head;

    protected class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
    public void LinkedList(){
        this.head = null;
        this.size = 0;
    }

    public void add(Object e, int index){
        Node currentNode = this.head;
        Node temp = new Node(e);
        if(this.head == null || this.size == 0){
            this.head = temp;
        }
        else if(index == 0) {
            temp.next = this.head;
            this.head = temp;
        }
        else{
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            temp.next = currentNode.next;
            currentNode.next = temp;
        }
        this.size++;
    }

    public void addFirst(Object e){
        this.add(e, 0);
    }

    public void addLast(Object e){
        this.add(e, this.size - 1);
    }

//    public LinkedList insert(Object e)
//    {
//        if (this.head == null) {
//            this.head = new Node(e);
//        }
//        else {
//            Node currentNode = this.head;
//            while (currentNode.next != null) {
//                currentNode = currentNode.next;
//            }
//            currentNode.next = new Node(e);
//        }
//        this.size++;
//        return this;
//    }

    public void remove(int index){
        Node currentNode = this.head;
        if(index == 0)
            this.head = currentNode.next;
        else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            currentNode.next = currentNode.next.next;
        }
        this.size--;
    }

    public void removeLast(){
        remove(this.size -1);
    }

    public void removeFirst(){
        remove(0);
    }

    public static void printList(LinkedList list)
    {
        Node currNode = list.head;

        System.out.print("LinkedList: ");

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.value + " ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
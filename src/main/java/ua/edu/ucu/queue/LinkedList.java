package ua.edu.ucu.queue;

import java.lang.reflect.Array;

public class LinkedList {
    private int size;
    private Node head;

    public class Node {
        Object value;
        Node next;

        Node(Object value) {
            this.value = value;
            this.next = null;
        }
    }
    public LinkedList LinkedList(){
        this.head = null;
        this.size = 0;
        return this;
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

    public Object remove(int index){
        Node currentNode = this.head;
        Node temp = null;
        if(index == 0) {
            temp = this.head;
            this.head = currentNode.next;
        }
        else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.next;
            }
            temp = currentNode.next;
            currentNode.next = currentNode.next.next;
        }
        this.size--;
        return temp;
    }

    public Object removeLast(){
        return remove(this.size -1);
    }

    public Object get(int index){
        if(index < 0 || index == 0 && this.head == null || index > this.size){
            throw new IndexOutOfBoundsException();
        }
        else{
            Node currentNode = this.head;
            for(int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.value;
        }
    }

    public Object getLast(){
        return this.get(this.size - 1);
    }

    public Object removeFirst(){
        return remove(0);
    }

    public Object[] toArray(){
        int index = 0;
        Object[] newArr = new Object[this.size];
        Node currentNode = this.head;
        while(currentNode.next != null){
            currentNode = currentNode.next;
            newArr[index] = currentNode.value;
            index++;
        }
        return newArr;
    }

    public String toString(){
        Object[] newArr = this.toArray();
        String res = "";
        for(Object i : newArr){
            res = "," + i + " ";
        }
        return res;
    }
}
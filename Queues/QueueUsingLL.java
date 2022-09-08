package Queues;

import LinkedList.Node;

public class QueueUsingLL<T> {
    private Node<Integer> front;
    private Node<Integer> rear;
    private int size;

    public QueueUsingLL(){
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(Node<Integer> data){
        Node<Integer> newNode = new Node<Integer>(data.data);
        if(front == null){
            front = newNode;
            rear = newNode;
        }
        else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    public int front(){
        if (front != null){
            return front.data;
        }
        else {
            return -1;
        }
    }

    public int dequeue(){
        if(front != null){
            int temp = front.data;
            front = front.next;
            size--;
            return temp;
        }
        else {
            return -1;
        }
    }
}

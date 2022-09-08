package Queues;

import java.util.Stack;

public class QueueUsingStacks<T> {
    Stack<Integer> s1;
    Stack<Integer> s2;
    private int front;

    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int elem){
        if(s1.empty()){
            front = elem;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
            s2.push(elem);
        }
        while (!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }

    public int pop(){
        s1.pop();
        if(!s1.empty()){
            front = s1.peek();
        }
        return front;
    }

    public boolean empty(){
        return s1.isEmpty();
    }

    public int peek(){
        if(!s2.isEmpty()){
            return s2.peek();
        }
        return front;
    }

}

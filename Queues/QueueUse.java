package Queues;

import java.util.LinkedList;

public class QueueUse {

    public static void main(String[] args) {
        //QueueUsingArray queue = new QueueUsingArray();
        //QueueUsingLL queue = new QueueUsingLL();
        QueueUsingStacks queue = new QueueUsingStacks();
//        queue.push(50);
        int arr[] = {10,20,30,40};
//        for (int i = 0; i < arr.length; i++){
//            System.out.println(arr[i]);
//        }


        for (int elem : arr){
           // try {
                queue.push(elem);
//            //} catch (QueueFullException e) {
//            //}
        }
        while (! queue.empty()){
            System.out.println(queue.pop());
        }
    }
}

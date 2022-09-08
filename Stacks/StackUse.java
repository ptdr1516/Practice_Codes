package Stacks;

public class StackUse {
    public static void main(String[] args) throws StackFullException, StackEmptyException {

//        StackUsingArray stack = new StackUsingArray();
        StackUsingLL stack = new StackUsingLL();
        int arr[] = {1,3,5,7,9,21,50};
        for(int i = 0; i < arr.length; i++) {
        	stack.push(arr[i]);
        }
        while(! stack.isEmpty()) {
        	System.out.println(stack.pop());
        }
//        stack.data[1] = 100;
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack.top());
//        stack.pop();
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
    }
}

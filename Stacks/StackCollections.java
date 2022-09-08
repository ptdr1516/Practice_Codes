package Stacks;

import java.util.Stack;

public class StackCollections {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        while(stack.isEmpty())
        {
            stack.push(10);
        }
        System.out.print(stack.pop()+" "+stack.size());

//        int[] arr = {1,3,4,8,9,15,19};
//        for (int elem : arr){
//            stack.push(elem);
//        }
//        while(!stack.isEmpty()){
//            System.out.println(stack.pop());
//        }
//        stack.push(10);
//        stack.peek();
//        System.out.println(stack.size());
//        stack.pop();
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
    }
}

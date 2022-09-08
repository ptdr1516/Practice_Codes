package Stacks;

public class StackUsingArray {

    private int data[];
    private int topIndex; //Index of the topmost element of stack
    public StackUsingArray(){
        data = new int[2];
        topIndex = -1;
    }

    public void push(int elem) {
        //If Stack is full
        if(topIndex == data.length - 1){
            
//            StackFullException e = new StackFullException();
//            throw e;
//            throw new StackFullException();
          //Throw StackFullException
            doubleCapacity();
        }
//        ++topIndex;
        data[++topIndex] = elem;
    }

    private void doubleCapacity() {
        System.out.println("Double Capacity");
        int[] temp = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] = temp[i];
        }
    }

    public int size(){
        return topIndex + 1;
    }
    public int top() throws StackEmptyException{
    	if(topIndex == -1) {
    		//Throw StackEmptyException
    		throw new StackEmptyException();
    		
    	}
    	return data[topIndex];
    }
    public int pop() throws StackEmptyException{
    	if(topIndex == -1) {
    		//Throw StackEmptyException
    		throw new StackEmptyException();
    	}
    	int temp = data[topIndex];
    	topIndex--;
    	return temp;
    }
    public boolean isEmpty(){
//        if(topIndex == -1){
//            return true;
//        }
//        else {
//            return false;
//        }
        return topIndex == -1;
    }
}

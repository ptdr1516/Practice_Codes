public class DynamicArray {
    private int[] data;
    private int nextElementIndex; //Keeps the track of next element index to be inserted at.
    public DynamicArray(){
        data = new int[5];
        nextElementIndex = 0;
    }

    public int size(){
        return nextElementIndex;
    }

    public boolean isEmpty(){
        return nextElementIndex == 0;
    }

    public int get(int i){
        if(i >= nextElementIndex){
            //Throw Error
            return -1;
        }
        return data[i];
    }
    public int removeLast() {
        if(nextElementIndex == 0){
            return -1;
        }
        int temp = data[nextElementIndex - 1];
        data[nextElementIndex - 1] = 0;
        nextElementIndex--;
        return temp;
    }

    public void set(int i, int elem) {
        if(i >= nextElementIndex){
            //Throw Error
            return;
        }
        data[i] = elem;
    }

    public void add(int elem) {
        if (nextElementIndex == data.length){
            doubleCapacity();
        }
        data[nextElementIndex] = elem;
        nextElementIndex++;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++){
            data[i] =  temp[i];
        }
    }
}

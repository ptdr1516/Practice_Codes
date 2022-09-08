import java.util.ArrayList;
public class DynamicArrayUse {
    public static void main(String[] args) {
        DynamicArray d = new DynamicArray();

        for (int i = 1; i < 100; i++) {
            d.add(100 + i);
        }
        System.out.println(d.size());
        System.out.println(d.get(98)); //Value at index 2
        d.set(3, 140); //Replace the vlaue at index 3 with 140
        System.out.println(d.get(3));

        while (!d.isEmpty()){
            System.out.println(d.removeLast()); //Remove the last element from array
            System.out.println("size - " + d.size());
        }
    }
}

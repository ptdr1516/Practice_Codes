package Hashmaps;
import java.util.Scanner;
import java.util.HashMap;

public class PairSumToZero {

    public static int PairSum(int[] input, int size) {
        HashMap<Integer, Integer> map = new HashMap<>();
        size = input.length;
        for (int i = 0; i < size; i++) {
            if (map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            }
            else {
                map.put(input[i], 1);
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            int val = 0 - input[i];
            if (map.containsKey(val)) {
                int a = map.get(input[i]);
                int b = map.get(val);

                if (input[i] == 0) {
                    int temp = (a * (a - 1))/2;
                    count += temp;
                }
                else {
                    int temp = a * b;
                    count += temp;
                }

                map.put(input[i], 0);
                map.put(val, 0);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc .nextInt();
        int array[] = new int[n];
        for(int i=0;i<n;i++) {
            array[i]= sc.nextInt();
        }
        System.out.println(PairSum(array, array.length));
    }
}

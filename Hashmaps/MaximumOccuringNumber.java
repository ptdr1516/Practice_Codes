package Hashmaps;

import java.util.HashMap;

public class MaximumOccuringNumber {

    public static int maxFreqNumber(int[] arr) {
        HashMap<Integer, Integer> output = new HashMap<>();

        int max = 0;
        for (int i:arr) {
            if (output.containsKey(i)) {
                output.put(i, output.get(i) + 1);
            }
            else {
                output.put(i, 1);
            }
        }

        int res = Integer.MIN_VALUE;
        for (int i:arr) {
            if (output.get(i) > max) {
                max = output.get(i);
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,2,2,3,1,6,2,5};
        System.out.println(maxFreqNumber(arr));
    }
}

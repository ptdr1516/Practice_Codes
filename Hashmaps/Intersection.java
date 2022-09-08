package Hashmaps;

import java.util.Arrays;
import java.util.HashMap;

public class Intersection {

    public static void intersection(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i:arr1) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            }
            else {
                map.put(i, 1);
            }
        }

        for (int i:arr2) {
            if (map.containsKey(i) && map.get(i) > 0) {
                System.out.print(i + " ");
                map.put(i, map.get(i) + 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2,6,8,5,4,3};
        int[] arr2 = {2,3,4,7};
        intersection(arr1,arr2);
    }
}

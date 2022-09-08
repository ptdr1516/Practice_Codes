package Hashmaps;

import java.util.HashMap;
import java.util.Scanner;

public class PairsWithDifferenceK {

    public static int getPairsWithDifferenceK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key:arr) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            }
            else {
                map.put(key, 1);
            }
        }

        int countPairs = 0;
        if (k == 0) {
            for (Integer i : map.keySet()) {
                int val = map.get(i);
                countPairs = countPairs + (val * (val - 1)) / 2;
            }
            return countPairs;
        }

        for (Integer i : map.keySet()) {
            if (map.containsKey(k + i)) {
                countPairs = countPairs + (map.get(i) * map.get(k + i));
            }
            if (map.containsKey(i - k)) {
                countPairs = countPairs + (map.get(i) * map.get(i - k));
            }
        }
        countPairs = countPairs / 2;
        return countPairs;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int k = s.nextInt();

        System.out.println(getPairsWithDifferenceK(arr, k));
    }
}
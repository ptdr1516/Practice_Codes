package Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    public static ArrayList<Integer> LCS(int[] arr) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (int val:arr) {
            map.put(val, true);
        }

        for (int val:arr) {
            if (map.containsKey(val - 1)) {
                map.put(val, false);
            }
        }
        int start = 0, maxLen = Integer.MIN_VALUE;

        for (int val:arr) {
            if (map.get(val) == true) {
                int len = 1;

                while (map.containsKey(val + len)) {
                    len++;
                }
                if (maxLen < len) {
                    maxLen = len;
                    start = val;
                }
            }
        }

        for(int i = 0; i < maxLen; i++) {
            output.add(start + i);
        }
        return output;
}

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        ArrayList<Integer> ans = LCS(arr);
        for (int num : ans) {
            System.out.println(num);
        }
    }
}

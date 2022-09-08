package PriorityQueues;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargest {

    public static void Klargest(int[] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }

        for (int i = k; i < input.length; i++) {

            if (pq.peek() < input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
//            int minVal = pq.peek();
//
//            if (minVal < input[i]) {
//                minVal = input[i];
//            }
//
//            if (minVal != pq.peek()) {
//                pq.poll();
//                pq.add(minVal);
//            }
//        }
//        ArrayList<Integer> arr = new ArrayList<>();
//
//        while (!pq.isEmpty()) {
//            arr.add(pq.poll());
//        }
//        return arr;
    }

    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        int n = s.nextInt();
        int input[] = new int[n];
        for (int j = 0; j < n; j++) {
            input[j] = s.nextInt();
        }
        int k = s.nextInt();
        Klargest(input, k);
    }
}

package PriorityQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InplaceHeapSort {

    public static void inplaceHeapSort(int[] arr) {
        int n = arr.length;;

        for (int i = (n/2) - 1; i >= 0; i--) {
            downHeapify(arr, i, n);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            downHeapify(arr, 0, i);
        }
    }

    private static void downHeapify(int[] arr, int i, int n) {
        int parentIndex = i;
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;

        while (leftChildIndex < n) {
            int minIndex = parentIndex;
            if (arr[minIndex] > arr[leftChildIndex]) {
                minIndex = leftChildIndex;
            }

            if (rightChildIndex < n && arr[minIndex] > arr[rightChildIndex]) {
                minIndex = rightChildIndex;
            }

            if (minIndex == parentIndex) {
                return;
            }

            int temp = arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex] = temp;

            parentIndex = minIndex;
            leftChildIndex = 2 * parentIndex + 1;
            rightChildIndex = 2 * parentIndex + 2;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException ,IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int input[] = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        InplaceHeapSort.inplaceHeapSort(input);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }
}

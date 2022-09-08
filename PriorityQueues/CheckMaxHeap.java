package PriorityQueues;

public class CheckMaxHeap {

    public static boolean checkMaxHeap(int[] arr) {
        return checkMaxHeapHelper(arr, 0);
    }

    private static boolean checkMaxHeapHelper(int[] arr, int si) {

        if (si == arr.length) {
            return true;
        }

        int parentIndex = si;
        int lefthildIndex = 2*parentIndex+1;
        int rightChildIndex = 2*parentIndex+2;

        boolean leftAns = true;
        boolean rightAns = true;

        if (lefthildIndex < arr.length) {
            if (arr[parentIndex] < arr[lefthildIndex]) {
                return false;
            }
            else {
                leftAns = checkMaxHeapHelper(arr, lefthildIndex);
            }
        }

        if (rightChildIndex < arr.length) {
            if (arr[parentIndex] < arr[rightChildIndex]) {
                return false;
            }
            else {
                rightAns = checkMaxHeapHelper(arr, rightChildIndex);
            }
        }
        return (leftAns && rightAns);
    }

    public static void main(String[] args) {
        int[] arr = {42, 20, 18, 6, 14, 11, 9, 4};
        System.out.println(checkMaxHeap(arr));
    }
}

import java.util.Scanner;

public class ArrayEquilibriumIndex {

    public static int EquilibriumIndex(int[] arr){
        int n = arr.length;

        // The only possible candidates a valid equilibrium index will lie from 1 to n - 1.
        for (int i = 1; i < n - 1; i++) {
            int leftSum = 0, rightSum = 0;

            // Finding the sum of left prefix of the array.
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }

            // Finding the sum of the right suffix after index i.
            for (int k = i + 1; k < n; k++) {
                rightSum += arr[k];
            }

            // If the condition is satisfied, then we return the index.
            if (leftSum != 0 && rightSum != 0 && leftSum == rightSum) {
                return i;
            }

        }

        // If we don't find an equilibrium index, then we return -1.
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,9,4,2};
        EquilibriumIndex(arr);
    }
}

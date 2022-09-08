import java.util.Scanner;

public class ArrayRotation {
    public static void rotate(int[] arr, int d){
        for (int i = 0; i < d; i++){
            int j , first;
            first = arr[0];
            for (j = 0; j < arr.length-1; j++){
                arr[j] = arr[j+1];
            }
            arr[j] = first;
        }
    }
    public static void printArray(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Rotate array by: ");
        int d = s.nextInt();
        System.out.println("Size of the array: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
        }
        rotate(arr,d);
        printArray(arr);
    }
}

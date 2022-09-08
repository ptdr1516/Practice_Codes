import java.util.Scanner;

public class BinarySearch {
    public static int binarySearch(int[] arr, int x){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if(arr[mid] == x){
                return mid;
            }
            else{
                if(arr[mid] < x){
                    start = mid + 1;
                }
                else if(arr[mid] > x){
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            arr[i] = s.nextInt();
        }
        System.out.print(x + " is present at index ");
        System.out.print(binarySearch(arr,x));
    }
}

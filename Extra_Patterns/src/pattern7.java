import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        int i,j;
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("*");
        for (i = 1; i<= n; i++){
            System.out.print("*");
            for (j = 1; j <= i; j++){
                System.out.print(j);
            }
            for (j = i - 1; j >= 1; j--){
                System.out.print(j);
            }
            System.out.print("*");
            System.out.println();
        }
        for (i = n - 1; i >= 1; i--){
            System.out.print("*");
            for (j = 1; j <= i; j++){
                System.out.print(j);
            }
            for (j = i - 1; j >= 1; j--){
                System.out.print(j);
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.print("*");
    }
}

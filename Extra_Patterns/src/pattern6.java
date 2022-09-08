import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int i = 0, j, space = 1;
        space = n - 1;
        for (j = 1; j <= n; j++){
            for (i = 1; i <= space; i++ ){
                System.out.print(" ");
            }
            space--;
            for (i = 1; i <= 2 * i - 1; i++){
                System.out.print("*");
            }
            System.out.println();
        }
        space = 1;
        for (j = 1; j <= n - i + 1; j++){
            for ( i = 1; i <= space; i++){
                System.out.print(" ");
            }
            space++;
            for (i = 1; i <= 2 * i - 1; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

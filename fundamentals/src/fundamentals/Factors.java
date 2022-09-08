package fundamentals;
import java.util.Scanner;
public class Factors {

	public static void main(String[] args) {
		int num;
        Scanner s = new Scanner(System.in);
        num = s.nextInt();
        for (int i = 2; i <= num; ++i) {
            if (num % i == 0 && num != i) {
                System.out.print(i + " ");
            }
	}
	}
}

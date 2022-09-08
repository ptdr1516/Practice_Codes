import java.util.Scanner;
public class Pattern16 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n =  s.nextInt();
		
		for(int i = 0; i <= 2 * n; i++) {
			int totalColsInRow = i > n ? 2 * n - i: i;
			for(int j = 0; j < totalColsInRow; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

}
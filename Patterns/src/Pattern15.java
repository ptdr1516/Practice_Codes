import java.util.Scanner;
public class Pattern15 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n =  s.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print((char)(n - i + 1 + 64));
			}
			System.out.println();
		}
	}

}
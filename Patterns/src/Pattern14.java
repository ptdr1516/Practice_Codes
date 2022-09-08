import java.util.Scanner;
public class Pattern14 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n =  s.nextInt();
		
		int i = 1;
		while(i <= n) {
			int j =1;
			while(j <= i) {
				char p = (char)('A' + j - 1);
                System.out.print(p);
				p = (char)(p + 1);
				j = j + 1;
			}
			System.out.println();
			i = i - 1;
		}
	}

}

package fundamentals;

import java.util.Scanner;

public class CharacterCase {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		char ch = s.next().charAt(0);
		int a = ch;
		if(a >= 65 && a <= 90 ) {
			System.out.println("1");
		}
		else if(a >= 97 && a <= 122) {
			System.out.println("0");
		}
		else {
			System.out.println("-1");
		}
	}

}

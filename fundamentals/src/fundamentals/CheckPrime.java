package fundamentals;

import java.util.Scanner;

public class CheckPrime {

	public static void main(String[] args) {
		int n, div = 2;
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
//		boolean isPrime = true;
		while(div <= n/2) {
			if(n % div == 0) {
//				System.out.println("Composite");
				System.out.println("Composite");
//				isPrime = false;
				return;
			}
			div = div + 1;
		}
		System.out.println("Prime");
//		if(isPrime) {
//			System.out.println("Prime");
//		}else {
//			System.out.println("Composite");
//		}
	}

}

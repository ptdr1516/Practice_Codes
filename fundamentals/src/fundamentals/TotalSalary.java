package fundamentals;
import java.util.Scanner;
import java.lang.Math;
public class TotalSalary {

	public static void main(String[] args) {
		Scanner s =  new Scanner(System.in);
		int bs = s.nextInt();
		String str = s.next();
		char ch = str.charAt(0);
		int all;
		if(ch == 65) {
			all = 1700;
		}
		else if(ch == 66) {
			all = 1500;
		}
		else {
			all = 1300;
		}
		double TotalSalary = ((bs + (0.20 * bs) + (0.50 * bs) + all) -(0.11 * bs));
		double abs = Math.round(TotalSalary);
		int a = (int)(abs);
		System.out.println(a);
	}

}

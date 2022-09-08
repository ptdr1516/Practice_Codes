package fundamentals;
import java.util.Scanner;
public class FahrenheitToCelsius {

	public static void main(String[] args) {
		
		int S, E, W, fah;
		Scanner s = new Scanner(System.in);
		S = s.nextInt();
		E = s.nextInt();
		W = s.nextInt();
		
		while(S <= E) {
			fah = ((5*(S - 32)/9));
			System.out.println(S + " " + fah);
			S += W;
		}
	}

}

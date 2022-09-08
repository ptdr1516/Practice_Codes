import java.util.Iterator;

public class main {

	public static void main(String[] args) {
//		pattern17(5);
		pattern18(4);
	}
	static void pattern18(int n) {
		for(int i = 0; i < 2 * n; i++) {
			int totalColsInRow = i > n ? 2 * n - i : i;
		
			int NoOfSpaces = n - totalColsInRow;
			for(int s = 0; s < NoOfSpaces; s++) {
				System.out.print(" ");
			}
			for(int j = 0; j < totalColsInRow; j++) {
				System.out.print("* ");
			}
			System.out.println();
			
//	static void pattern17(int n) {
//		for(int i = 0; i < 2 * n; i++) {
//			int totalColsInRow = i > n ? 2 * n - i - 1: i;
//			for(int j = 0; j < totalColsInRow; j++) {
//				System.out.print("* ");
//			}
//			System.out.println();
		}
	}

}

package fundamentals;
import java.util.Scanner;
public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int n,i = 1;
        n = s.nextInt();
        while(i <= 10){
            System.out.println(n*i);
            i = i+1;
        }
}
}


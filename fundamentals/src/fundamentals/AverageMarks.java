package fundamentals;

import java.util.Scanner;

public class AverageMarks {


	public static void main(String[] args) {
		
        int m1, m2, m3;
        int avg;
		Scanner s =  new Scanner(System.in);
        String name = s.next();
        char ch = name.charAt(0);
        
        m1 =  s.nextInt();
        m2 =  s.nextInt();
        m3 =  s.nextInt();
        
        System.out.println(ch);
        avg = (m1 + m2 + m3) / 3;
        System.out.println(avg);

		
	}

}

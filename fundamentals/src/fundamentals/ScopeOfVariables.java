package fundamentals;

public class ScopeOfVariables {

	public static void main(String[] args) {
		
		int i = 1;
		while(i <= 5) {
			int j = 10;
//			int j = 10;
			System.out.println(j);
			i++;
			j++;
		}
		System.out.println(i);
//		System.out.println(j); j is outside the scope
		
//		if(a >= 100) {
//			int b = 10; 
//			System.out.println(b);
//		}else {
//			int b = 20;
//			System.out.println(b);
//		}
//		System.out.println(a);
	}

}

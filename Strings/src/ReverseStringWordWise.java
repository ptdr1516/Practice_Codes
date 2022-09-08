import java.util.Scanner;

public class ReverseStringWordWise {
    public static String reverseWordWise(String input) {
        // Write your code here
        StringBuffer str = new StringBuffer();
        input = " " + input;
        int CWE = input.length() - 1;
        for(int i = input.length() - 1; i >= 0; i--){
            if(input.charAt(i) == ' '){
                str.append(input.substring(i,CWE+1));
                CWE = i - 1;
            }
        }
        return (str.toString()).trim();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(reverseWordWise(str));
    }
}

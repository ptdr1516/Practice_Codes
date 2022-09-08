import java.util.Scanner;

public class StringPalindrome {
    public static void CheckPalindrome(String str) {
        String reversedString = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedString += str.charAt(i);
        }
        if (reversedString.equals(str)) {
            System.out.println(str + " is a Palindrome");
        } else {
            System.out.println(str + " is not a Palindrome");
        }
    }
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            String str1 = s.nextLine();
            CheckPalindrome(str1);
        }
    }


import java.util.Scanner;

public class Keypad {

    public static String getOptions(int digits) {
        if (digits == 2) {
            return "abc";
        }
        if (digits == 3) {
            return "def";
        }
        if (digits == 4) {
            return "ghi";
        }
        if (digits == 5) {
            return "jkl";
        }
        if (digits == 6) {
            return "mno";
        }
        if (digits == 7) {
            return "pqrs";
        }
        if (digits == 8) {
            return "tuv";
        }
        if (digits == 9) {
            return "wxyz";
        }
        return "";
    }
    public static String[] keypadCombinations(int input) {
        if (input == 0) {
            String[] output = new String[1];
            output[0] = "";
            return output;
        }

        String[] smallOutput = keypadCombinations(input/10);
        int lastDigit = input % 10;
        String lastDigitOptions = getOptions(lastDigit);
        String[] output = new String[smallOutput.length * lastDigitOptions.length()];

        int k = 0;
        for (int i = 0; i < smallOutput.length; i++) {
            for (int j = 0; j < lastDigitOptions.length(); j++) {
                output[k] = smallOutput[i] + lastDigitOptions.charAt(j);
                k++;
            }
        }
        return output;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number");
        int input = s.nextInt();
        String[] output = keypadCombinations(input);
        for (String outputString : output) {
            System.out.println(outputString);
        }
    }
}

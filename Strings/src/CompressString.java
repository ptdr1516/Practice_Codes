import java.lang.String;
import java.util.Scanner;

public class CompressString {

    public static String getCompressedString(String str){
        int n = str.length();
        String compressString = "";
        int localCount = 0;
        char currentCharacter = '-';
        int i = 0, j = 0;

        for (i = 0; i < n; ++i){
            currentCharacter = str.charAt(i);
            localCount = 0;

            for (j = i; j < n; ++j) {
                if (currentCharacter == str.charAt(j))
                    localCount++;
                else
                    break;
            }
            if (localCount == 1) {
                compressString = compressString + currentCharacter;
            } else {
                compressString = compressString + currentCharacter + String.valueOf(localCount);
            }
            i = j - 1;
        }
        return compressString;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(getCompressedString(str));
    }
}

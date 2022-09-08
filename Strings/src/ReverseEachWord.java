import java.util.Scanner;

public class ReverseEachWord {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str =  s.nextLine();
        System.out.println(reverseEachWord(str));
    }

    public static String reverseEachWord(String str){
        String output = "";
        int i = 0;
        int CWS = 0; //Current Word Start

        for (i = 0; i < str.length(); i++){
            if (str.charAt(i) == ' '){
                String reversedWord = "";
                int CWE = i - 1; //Current Word End
                for (int j = CWS; j <= CWE; j++ ){
                    reversedWord = str.charAt(j) + reversedWord;
                }
                output += reversedWord + " ";
                CWS = i + 1;

            }
        }
        String reversedWord = "";
        int CWE = i - 1; //Current Word End
        for (int j = CWS; j <= CWE; j++ ){
            reversedWord = str.charAt(j) + reversedWord;
        }
        output += reversedWord;
        return output;
    }


}

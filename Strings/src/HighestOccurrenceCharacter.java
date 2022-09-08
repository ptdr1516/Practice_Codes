import java.util.Arrays;
import java.util.Scanner;

public class HighestOccurrenceCharacter {

    public static void highestOccurringChar(String str){
        char[] tempArray = str.toCharArray();
        Arrays.sort(tempArray);
        String s = new String(tempArray);
        int n = s.length();
        char ans = '-';
        int max_count = 0, count = 1;
        for (int i = 1; i <= n; i++){
            if(i == n || (s.charAt(i) != s.charAt(i-1))){
                if(max_count < count){
                    max_count = count;
                    ans = s.charAt(i-1);
                }
                count = 1;
            }
            else {
                count++;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        highestOccurringChar(str);
    }

}

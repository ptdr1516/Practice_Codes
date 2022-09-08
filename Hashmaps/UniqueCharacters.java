package Hashmaps;

import java.util.HashMap;

public class UniqueCharacters {

    public static String uniqueChar(String str) {
        String output = "";
        HashMap<Character, Integer> exist = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (exist.containsKey(str.charAt(i))) {
                continue;
            }
            output += str.charAt(i);
            exist.put(str.charAt(i), 1);
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "ababacd";
        System.out.println(uniqueChar(str));
    }
}

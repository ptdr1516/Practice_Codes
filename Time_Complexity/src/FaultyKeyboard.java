import java.util.*;

public class FaultyKeyboard {

    // ~~~~~~~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~~~~~

    public static boolean isPossible(String name, String typed) {
        // Write your code here

        if(name.length() > typed.length())
            return false;

        int i = 0;
        int j = 0;

        while(i < name.length() && j < typed.length())
        {
            if(name.charAt(i) == typed.charAt(j))
            {
                i++;
                j++;
            }
            else if(i > 0 && name.charAt(i-1) == typed.charAt(j))
            {
                j++;
            }
            else{
                return false;
            }
        }

        while(j < typed.length())
        {
            if(name.charAt(i-1) != typed.charAt(j))
                return false;
            j++;
        }

        if(i < name.length())
            return false;

        return true;
    }

    // ~~~~~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for (int i = 0; i < n; i++){
            String name = scn.next();
            String typed = scn.next();

            boolean res = isPossible(name, typed);
            System.out.println(res);
        }



    }
}
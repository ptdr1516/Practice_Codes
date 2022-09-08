import java.util.*;
public class main {

    public static void main(String[] args) {
        Scanner s =new Scanner(System.in);
        int i,j;
        int n=s.nextInt();
        int[] num = new int[n];

        for(i = 0;i < n; i++)
        {
            num[i] = s.nextInt();
        }
        if(CheckAP(num) == 1){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
    public static int CheckAP(int[] num)
    {
        int iDiff = num[1] - num[0];
        for(int i = 0; i < num.length-1; i++)
        {
            if((num[i + 1] - num[i]) != iDiff)
                return -1;
        }
        return 1;
    }
}

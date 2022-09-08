import java.util.Scanner;

public class Main {
    public static void func(int n)
    {
        int sum=0;
        for(int i=1;i<n;i++)
        {
            for(int j=1;j<n*n;j++)
            {
                sum+=i;
            }
        }
        System.out.println(sum);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

    }
}

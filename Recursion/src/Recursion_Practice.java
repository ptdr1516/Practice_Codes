public class Recursion_Practice {
    public static int fact(int n){
        if(n == 0){
            return 1;
        }
        int smallOutput = fact(n - 1); //Base Case
        int output = n * smallOutput;
        return output;
    }
    public static int sumn(int n){
        if(n == 0){
            return 0;
        }
        int smallOutput = sumn(n - 1); //Base Case
        int output = n + smallOutput;
        return output;
    }
    public static int power(int x, int n){
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        int smallOutput = power(x,n - 1); //Base Case
        int output = x * smallOutput;
        return output;
    }
    public static int countDigits(int n){
        if(n == 0){
            return 0;
        }
        int smallOutput = countDigits(n/10);
        int output = 1 + smallOutput;
        return output;
    }

    public static void print1ToN(int n){
        if(n == 0){
            return;
        }
        print1ToN(n - 1);
        System.out.println(n);
    }

    public static int fibonnaciNum(int n){
        if (n == 1 || n == 2){
            return 1;
        }

        int fib_n_1 = fibonnaciNum(n - 1);
        int fib_n_2 = fibonnaciNum(n - 2);
        int output = fib_n_1 + fib_n_2;
        return output;
    }
    public static boolean isSorted(int a[]){
        if(a.length == 1){
            return true;
        }
        if(a[0] > a[1]){
            return false;
        }

        int smallArray[] = new int[a.length - 1];
        for (int i = 1; i < a.length; i++){
            smallArray[i - 1] = a[i];
        }
        boolean isSmallArraySorted = isSorted(smallArray);
        return isSmallArraySorted;
    }
    public static boolean isSoretdBetter(int[] a, int si){
        //si :  StartIndex
        if(si == a.length -1){
            return true;
        }
        if(a[si] > a[si+1]){
            return false;
        }
        return isSoretdBetter(a,si+1);
    }
    public static void main(String[] args) {
        System.out.println("Factorial : "+fact(5));
        System.out.println("Sum : "+sumn(10));
        System.out.println("Power : "+power(3,4));
        System.out.println("Count Digit : "+countDigits(156));
        print1ToN(10);
        System.out.println("Fibonnaci Number : "+fibonnaciNum(5));
        System.out.println("Array is Sorted : "+isSorted(new int[]{1, 2, 3, 4, 5}));
        System.out.println("Array Sorted better version : "+isSoretdBetter(new int[]{1,2,3,4,5,6}, 0));
    }
}

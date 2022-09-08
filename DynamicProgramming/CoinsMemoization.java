package DynamicProgramming;

import java.util.HashMap;

public class CoinsMemoization {

//    public static long bytelandian(long n, HashMap<Long, Long> memo) {
//        if (n == 0) {
//            return n;
//        }
//
//        if (memo.containsKey(n)) {
//            return memo.get(n);
//        }
//
//        long val = bytelandian(n/2, memo) + bytelandian(n/3, memo) + bytelandian(n/4, memo);
//
//        if (val > n) {
//            memo.put(n, val);
//        }
//        else {
//            memo.put(n, n);
//        }
//        return memo.get(n);
//    }
    static long[] state = new long[1000];

    public static long americanDollar(long n) {
        if (n < 10) {
            return n;
        }

        if (state[(int) n] != 0) {
            return state[(int) n];
        }

        long x = americanDollar(n/2) + americanDollar(n/3) + americanDollar(n/4);
        state[(int) n] = Math.max(x, n);
        return state[(int) n];
    }

    public static void main(String[] args) {
        long n = 2;
        System.out.println(americanDollar(n));
    }
}

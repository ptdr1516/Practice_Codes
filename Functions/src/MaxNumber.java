public class MaxNumber {
    public class Solution {

        public static int max_number(int n){
            {

                for (int j = 0; j < 1; j++) {

                    int ans = 0;
                    int i = 1;

                    while (n / i > 0) {

                        int temp = (n / (i * 10)) * i + (n % i);
                        i *= 10;
                        ans = Math.max(ans, temp);
                    }
                    n = ans;
                }
                return n;
            }
        }
    }

}

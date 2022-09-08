package DynamicProgramming;

public class MinimumCountOfSquares {

    public static int minCount(int n) {
        int[] storage = new int[n + 1];
        storage[0] = 0;
        storage[1] = 1;

        for (int i = 2; i <= n; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 1; j <= Math.sqrt(i); j++) {
                int count = storage[i - (j * j)];
                if (min > count) {
                    min = count;
                }
            }
            storage[i] = min + 1;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(minCount(n));
    }
}

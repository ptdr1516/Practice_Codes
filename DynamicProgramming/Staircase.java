package DynamicProgramming;

public class Staircase {
    public static long staircase(int n) {
        if (n == 1) {
            return 1;
        }

        long[] storage = new long[n + 1];
        storage[0] = 1;
        storage[1] = 1;
        storage[2] = 2;

        for (int i = 3; i <= n; i++) {
            storage[i] = storage[i - 1] + storage[i - 2] + storage[i - 3];
        }
        return storage[n];
    }

    public static void main(String[] args) {
        System.out.println(staircase(10));
    }
}

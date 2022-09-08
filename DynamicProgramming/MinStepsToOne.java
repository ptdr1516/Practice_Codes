package DynamicProgramming;

public class MinStepsToOne {
    public static int countMinStepsToOne(int n) {
        int[] storage = new int[n + 1];
        storage[0] = 1;

        for (int i = 2; i <= n; i++) {
            int min = storage[i - 1];

            if (i % 3 == 0) {
                if (min > storage[i / 3]) {
                    min = storage[i / 3];
                }
            }
            if (i % 2 == 0) {
                if (min > storage[i / 2]) {
                    min = storage[i / 2];
                }
            }
            storage[i] = 1 + min;
        }
        return storage[n];
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(countMinStepsToOne(n));
    }
}

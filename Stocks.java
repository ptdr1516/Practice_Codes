import com.sun.source.tree.BreakTree;

import java.util.Stack;

public class Stocks {

    public static int[] stockSpan(int[] price) {
        int[] span = new int[price.length];
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        int i;
        for (i = 1; i < price.length; i++) {
            while (!s.isEmpty() && price[s.peek()] <= price[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - s.peek();
            }
            s.push(i);
        }
        return span;
    }

    public static void main(String[] args) {
        int[] arr = {60, 70, 80, 100, 90, 75, 80, 120};
        System.out.println(stockSpan(arr));
    }

}

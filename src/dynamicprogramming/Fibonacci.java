package dynamicprogramming;

import org.junit.Test;
import static org.junit.Assert.*;

public class Fibonacci {

    public int fibonacci(int i) {
        if (i == 0) return 0;
        if (i == 1) return 1;
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    @Test
    public void testFibonacci() {
        assertEquals(fibonacci(0), 0);
        assertEquals(fibonacci(1), 1);
        assertEquals(fibonacci(2), 1);
        assertEquals(fibonacci(3), 2);
        assertEquals(fibonacci(4), 3);
        assertEquals(fibonacci(5), 5);
        assertEquals(fibonacci(6), 8);
    }

    public int fibonacciMem(int n) {
        return fibonacci(n, new int[n + 1]);
    }

    public int fibonacci(int i, int[] memo) {
        if (i == 0 || i == 1) return i;

        if (memo[i] == 0) {
            memo[i] = fibonacci(i - 1, memo) + fibonacci(i - 2, memo);
        }
        return memo[i];
    }

    public int fibonacciBottomUp(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;

        int[] memo = new int[n];
        memo[0] = 0;
        memo[1] = 1;

        for (int i = 2; i < n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }

        return memo[n - 1] + memo[n - 2];
    }


    @Test
    public void testFibonacciMem() {
        assertEquals(fibonacciMem(7), 13);
        assertEquals(fibonacciMem(8), 21);
        assertEquals(fibonacciMem(9), 34);
    }

}

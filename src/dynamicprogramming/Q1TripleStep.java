package dynamicprogramming;

import org.junit.Test;
import static org.junit.Assert.*;

public class Q1TripleStep {

    public int solution(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;

        return solution(n - 1) + solution(n - 2) + solution(n - 3);
    }

    @Test
    public void testSolution() {
        assertEquals(solution(0), 0);
        assertEquals(solution(1), 1);
        assertEquals(solution(2), 2);
        assertEquals(solution(3), 4);
        assertEquals(solution(4), 7);
        assertEquals(solution(5), 13);
    }

    public int memoizedSolution(int n) {

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 4;

        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        memo[3] = 4;

        for (int i = 4; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2] + memo[i - 3];
        }
        return memo[n];
    }

    @Test
    public void testMemoizedSolution() {
        assertEquals(memoizedSolution(0), 0);
        assertEquals(memoizedSolution(1), 1);
        assertEquals(memoizedSolution(2), 2);
        assertEquals(memoizedSolution(3), 4);
        assertEquals(memoizedSolution(4), 7);
        assertEquals(memoizedSolution(5), 13);
        assertEquals(memoizedSolution(50), 906045778);
    }

}

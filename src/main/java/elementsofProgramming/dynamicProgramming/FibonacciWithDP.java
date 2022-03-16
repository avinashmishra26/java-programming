package elementsofProgramming.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by avinashkumarmishra on 27/09/21.
 *  Caching intermediate results makes the time complexity for computing the nth
 *  Fibonacci number linear in O(n) at the expense of 0(n) sapce complexity.
 *  2022
 */
public class FibonacciWithDP {

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {


        fibonacci(7);

        System.out.println(map.get(7));

        Integer[] dp = new Integer[11];
        dp[0] = 0;
        dp[1] = 1;

        System.out.println(fibonacciDP(10, dp));

        System.out.println(fibonacciDP(10));
    }

    //using tabulation
    private static int fibonacciDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    private static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        if (!map.containsKey(n)) {
            map.put(n, fibonacci(n-1) + fibonacci(n-2));
        }
        return map.get(n);
    }

    private static int fibonacciDP(int n, Integer[] dp) {

        if(dp[n] != null) {
            //System.out.println(n);
            return dp[n];
        } else {
            //System.out.println(n);
            int res = fibonacciDP(n-1, dp) + fibonacciDP(n-2, dp);
            dp[n] = res;
            return dp[n];
        }
    }
}

package cracking.coding.interview.dynamicProgram;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 11/10/21.
 */
public class MinimumCoinsRequiredDP {

    public static void main(String[] args) {

        // more optimized and code efficient
        System.out.println("more optimized and code efficient :: " +getMinimumCoin(new int[]{2, 3, 7}, 12));

        // more optimized and code efficient
        System.out.println("more optimized and code efficient :: " +getMinimumCoin(new int[]{2}, 3));
    }


    static int getMinimumCoin(int[] values, int total) {
        int[] dp = new int[total+1];

        Arrays.fill(dp, total+1);
        dp[0] = 0;

        for (int v : values) {
            for ( int i = v; i <= total; i++) {
                if ( (dp[i - v]) != (total + 1)) {
                    dp[i] = Math.min(1 + dp[i - v], dp[i]);
                }
            }
        }
        return dp[total] == (total+1) ? -1 : dp[total];
    }
}

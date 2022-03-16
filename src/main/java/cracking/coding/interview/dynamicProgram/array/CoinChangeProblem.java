package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 14/03/22.
 * Infinite number of coins supply
 * https://leetcode.com/problems/coin-change-2/
 */

public class CoinChangeProblem {

    public static void main(String[] args) {
        System.out.println(getCoinChangeProblem(new int[]{2,3,5, 6}, 10));

        System.out.print(getCoinChangeProblem(new int[]{2, 3, 7}, 12));
    }

    private static int getCoinChangeProblem(int[] coins, int sum) {

        int[] dp = new int[sum+1];
        dp[0] = 1;

        for(int coin = 0; coin < coins.length; coin++) {
            int coin_value = coins[coin];
            for(int i = coin_value; i <= sum; i++) {
                dp[i] = dp[i] + dp[i-coin_value];
            }
        }
        return dp[sum];
    }
}
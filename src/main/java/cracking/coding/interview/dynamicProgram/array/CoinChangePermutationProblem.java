package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 14/03/22.
 *
 * Infinite number of coins supply
 */

public class CoinChangePermutationProblem {

    public static void main(String[] args) {
        System.out.println(getCoinChangePermutationProblem(new int[]{2,3,5}, 7));

        System.out.print(getCoinChangePermutationProblem(new int[]{2, 3, 7}, 12));
    }

    private static int getCoinChangePermutationProblem(int[] coins, int sum) {

        int[] dp = new int[sum+1];
        dp[0] = 1;

        for(int cnt = 1; cnt <= sum; cnt++) {
            for(int coin: coins) {
                if( cnt >= coin){
                    dp[cnt] += dp[cnt-coin];
                }

            }
        }
        return dp[sum];
    }
}
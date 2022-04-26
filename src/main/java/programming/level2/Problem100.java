package programming.level2;

/**
 * Created by avinash on 18/04/2022.
 * https://leetcode.com/problems/perfect-squares/
 */
public class Problem100 {

    private static int getPrefectSquares(int num) {

        if(num <= 0) return 0;

        int[] dp = new int[num+1];

        for(int i = 1; i <= num; i++) {
            int minCombination = Integer.MAX_VALUE;

            int j = 1;
            while(true) {
                int sq = (int)Math.pow(j, 2);
                if( (i - sq) < 0) {
                    break;
                }
                minCombination = Math.min(dp[i - sq], minCombination);
                j++;
            }
            dp[i] = minCombination + 1;
        }
       return dp[num];
    }
}

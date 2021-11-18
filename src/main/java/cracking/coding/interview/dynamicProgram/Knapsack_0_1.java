package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 24/10/21.
 */
public class Knapsack_0_1 {

    public static void main(String[] args) {

        int[][] grid = {{2,15}, {5,14}, {1,10}, {3,45}, {4, 30}};
        System.out.print(getKnapsack(grid, 7));

    }

    private static int getKnapsack(int[][] WV , int target) {
        int[][] dp = new int[WV.length + 1][target + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if( i==0 || j==0) {
                    dp[i][j] = 0;
                } else {
                    int weight = WV[i-1][0];
                    int value = WV[i-1][1];

                    if ( j-weight >= 0 ) {
                        dp[i][j] = Math.max(dp[i-1][j] , dp[i-1][j-weight] + value) ;
                    } else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

            }
        }

        return dp[WV.length][target];
    }
}

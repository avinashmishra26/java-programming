package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 24/10/21.
 * 2022
 */
public class TargetSumSubsets {

    public static void main(String[] args) {

        System.out.print(getTargetSumSubsets(new int[]{4,2,7,1,3}, 10));

    }


    private static boolean getTargetSumSubsets(int[] values, int target) {
        boolean[][] dp = new boolean[values.length+1][target+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if ( i == 0 ) {
                    if (j==0)
                        dp[i][j] = true;
                } else if( j == 0){
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j] ||  ( (j-values[i-1] >= 0) && dp[i-1][j-values[i-1]]) ) {
                        dp[i][j] = true;
                    }
                }

            }
        }
        return dp[values.length][target];
    }
}

package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 07/11/21.
 *
 * Climbing stair with variable jump at each step
 *
 * 2022
 */
public class ClimbStairs {

    public static void main(String[] args) {

        System.out.println(countPaths(6));

        System.out.print(getClimbStairWithVariableJump(6, new int[]{2,3,0,1,2,3}));
    }


    // Number of paths
    private static int countPaths(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            int cnt = 0;

            if( i-1 >= 0) {
                cnt += dp[i-1];
            }
            if(i-2 >= 0){
                cnt += dp[i-2];
            }

            if(i-3 >= 0){
                cnt += dp[i-3];
            }
            dp[i] = cnt;
        }
        return dp[n];
    }

    public static int getClimbStairWithVariableJump(int stairs, int[] jumps) {

        int[] dp = new int[stairs+1];

        dp[stairs] = 1;

        for(int i = stairs-1, j = jumps.length-1; i >= 0; i--, j--) {

            int cnt = 0;
            int jump = jumps[j];
            for(int k = 1; k <= jump; k++) {

                if(k+i > stairs) break;

                cnt += dp[k+i];
            }

            dp[i] = cnt;
        }

        return dp[0];
    }
}

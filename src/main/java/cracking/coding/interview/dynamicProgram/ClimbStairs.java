package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 07/11/21.
 *
 * Climbing stair with variable jump at each step
 *
 */
public class ClimbStairs {

    public static void main(String[] args) {

        System.out.print(getClimbStairWithVariableJump(6, new int[]{2,3,0,1,2,3}));
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

package cracking.coding.interview.dynamicProgram.robber;

/**
 * Created by avinashkumarmishra on 12/10/21.
 */
public class HouseRobberProblem {

    public static void main(String[] args) {
        System.out.print(rob(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {

        int[] dp = new int[nums.length+1];

        dp[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }
}

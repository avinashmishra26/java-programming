package cracking.coding.interview.dynamicProgram.robber;

/**
 * Created by avinashkumarmishra on 12/10/21.
 * 2022
 */
public class HouseRobberProblem {

    public static void main(String[] args) {
        System.out.println(rob(new int[]{2,7,9,3,1}));


        System.out.print(getAmount(new int[]{2,7,9,3,1}));
    }

    public static int rob(int[] nums) {

        int[] dp = new int[nums.length+1];

        dp[nums.length - 1] = nums[nums.length - 1];

        for(int i = nums.length - 2; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }

    //travel forward
    private static int getAmount(int[] nums) {

        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        dp[1]  = nums[0];

        for(int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+nums[i-1], dp[i-1]);
        }
        return dp[nums.length];
    }
}

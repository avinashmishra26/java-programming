package cracking.coding.interview.dynamicProgram.robber;

/**
 * Created by avinashkumarmishra on 18/11/21.
 * https://leetcode.com/problems/house-robber-ii/
 */
public class HouseRobber2 {


    public static void main(String[] args) {

        int[] arr = new int[]{2,7,9,3,1};

        System.out.print(Math.max(rob2(arr, 0, arr.length-2), rob2(arr, 1, arr.length-1) ));
    }


    public static int rob2(int[] nums, int start, int end) {

        int[] dp = new int[end - start + 2];

        dp[dp.length - 2] = nums[end];

        for(int i = dp.length - 3, j = end-1; i >= 0; i--, j--) {
            dp[i] = Math.max(nums[j] + dp[i+2], dp[i+1]);
        }
        return dp[0];
    }


}

package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinash on 18/04/2022.
 * https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {


    public static void main(String[] args) {

        System.out.print(getLIS(new int[]{10,22, 9, 33, 21, 50, 41, 60, 80, 1}));
    }

    private static int getLIS(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = 1;
        int maxLIS = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {

            int tempMax = 0;

            for(int j = i-1; j >=0; j--) {
                if(arr[j] <= arr[i] ) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] = tempMax+1;
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return maxLIS;
    }

}

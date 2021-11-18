package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 23/10/21.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

 * Note: You can only move either down or right at any point in time.
 * https://leetcode.com/problems/minimum-path-sum/

 */
public class MinimumPathSum {

    public static void main(String[] args) {

        int[][] grid = {{1,2,3},{4,5,6}};
        System.out.print(getMinimumPathSum(grid));

    }

    private static int getMinimumPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for(int i = grid.length-1; i >= 0; i--) {

            for(int j = grid[0].length-1; j >= 0; j--) {

                if ( i == grid.length-1 && j == grid[0].length-1) {
                    dp[i][j] = grid[i][j];
                } else {
                    int rightVal =  (j+1) < grid[0].length ?  dp[i][j+1] : Integer.MAX_VALUE;

                    int downValue =  (i+1) < grid.length ?  dp[i+1][j] : Integer.MAX_VALUE;

                    dp[i][j] = Math.min(rightVal, downValue) + grid[i][j];
                }
            }
        }

        return dp[0][0];
    }
}



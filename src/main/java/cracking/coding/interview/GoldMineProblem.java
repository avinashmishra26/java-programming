package cracking.coding.interview;

/**
 * Created by avinashkumarmishra on 12/10/21.
 *
 * GoldMineProblem with 2-D array
 *
 */
public class GoldMineProblem {


    public static void main(String[] args) {


        int[][] a = {{0,1,4,2,8,2}, {4,3,6,5,0,4}, {1,2,4,1,4,6}, {2,0,7,3,2,2}, {3,1,5,9,2,4}, {2,7,0,8,5,1}};

        System.out.print(getMaximumGold(a));
    }

    public static  int getMaximumGold(int[][] grid) {

        int[][] dp = new int[grid.length][grid[0].length];
        int max = 0;

        for (int col = dp[0].length - 1; col >= 0; col--) {
            max = 0;
            for (int row = 0; row < dp.length; row++) {
                if (col == dp[0].length - 1) {
                    dp[row][col] = grid[row][col];
                } else {
                    int firstVal = (row - 1) < 0 ? 0 : dp[row - 1][col + 1];

                    int secondValue = dp[row][col + 1];

                    int thridValue = (row + 1) >= dp.length ? 0 : dp[row + 1][col + 1];

                    dp[row][col] = grid[row][col] + Math.max(firstVal, Math.max(secondValue, thridValue));

                    if (dp[row][col] > max) {
                        max = dp[row][col];
                    }
                }
            }
        }
        return max;
    }


}

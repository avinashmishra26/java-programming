package elementsofProgramming.dynamicProgramming;

/**
 * Created by avinashkumarmishra on 07/11/21.
 *
 * COUNT THE NUMBER OF WAYS TO TRAVERSE A 2D ARRAY
 *
 * All moves must either go right or down
 *
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(traverse2DArrayDP(new int[5][5]));


        //Recursion
        int[] res = new int[1];
        traverse2DArrayUsingRecurrsion(new int[5][5], 0, 0, res);
        System.out.println(res[0]);
    }

    //DP
    private static int traverse2DArrayDP(int[][] arr) {

        int[][] dp  = new int[arr.length][arr[0].length];

        for(int i = dp.length - 1; i >= 0; i--) {
            for(int j = dp[0].length - 1; j >= 0; j--) {

                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = 1;
                } else {
                    int cnt = 0;

                    if (j < dp[0].length - 1) {
                        cnt = dp[i][j + 1];
                    }

                    if (i < dp.length - 1) {
                        cnt += dp[i + 1][j];
                    }
                    dp[i][j] = cnt;
                }

            }
        }
        return dp[0][0];
    }

    private static void traverse2DArrayUsingRecurrsion(int[][] arr, int row, int col, int[] res) {

        if( row >= arr.length || col >= arr[0].length) return;

        if( row == arr.length-1 && col == arr[0].length-1) {
            res[0] += 1;
            return;
        }


        traverse2DArrayUsingRecurrsion(new int[5][5], row, col+1, res);
        traverse2DArrayUsingRecurrsion(new int[5][5], row+1, col, res);

    }
}

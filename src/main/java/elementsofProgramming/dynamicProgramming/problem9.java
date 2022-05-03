package elementsofProgramming.dynamicProgramming;

/**
 * Created by avinashkumarmishra on 04/10/21.
 *
 * PICK UP COINS FOR MAXIMUM GAIN
 * Consider a row of n coins of values v1 . . . vn, where n is even.
 * We play a game against an opponent by alternating turns.
 * In each turn, a player selects either the first or last coin from the row,
 * removes it from the row permanently, and receives the value of the coin.
 * Determine the maximum possible amount of money we can definitely win if we move first.
 * Note: The opponent is as clever as the user.
 *
 * 2022
 */
public class problem9 {

    public static void main(String[] args) {
        System.out.println(optimalStratergy(new int[]{20, 30, 2, 10}));

        System.out.println(optimalStratergy(new int[]{25, 5, 10, 5, 10, 5, 10, 25 , 1, 25, 1, 25, 1, 25, 5, 10}));


        int[] res = new int[1];
        optimalStratergyRecurr(new int[]{25, 5, 10, 5, 10, 5, 10, 25 , 1, 25, 1, 25, 1, 25, 5, 10}, 0, 15, res, 0, true);
        System.out.println(res[0]);

    }


    //DP
    public static int optimalStratergy(int[] arr) {

        int[][] dp = new int[arr.length][arr.length];

        for ( int g = 0; g < arr.length; g++) {
            for ( int i = 0, j = g; j < arr.length ; i++, j++ ) {
                if ( g == 0) {
                    dp[i][j] = arr[i];
                } else if ( g == 1 ){
                    dp[i][j] = Math.max(arr[i], arr[j]);
                } else {

                    // if ith value is picked up then assuming user will get the min of left out of value after 2nd user has choose
                    // i -> i+1, j
                    // either -> (i+2, j) or (i+1, j-1)
                    int val1 = arr[i] + Math.min(dp[i+2][j], dp[i+1][j-1]);

                    // if jth value is picked up then assuming user will get the min of left out of value after 2nd user has choose
                    // j -> i, j-1
                    // either -> (i+1, j-1) or (i, j-2)
                    int val2 = arr[j] + Math.min(dp[i+1][j-1], dp[i][j-2]);

                    dp[i][j] = Math.max(val1, val2);
                }
            }
        }

        return dp[0][arr.length - 1];
    }


    //recursion
    public static void optimalStratergyRecurr(int[] arr, int start, int end, int[] max, int sumsf, boolean aChosess) {

        if ( start > end) {
            max[0] = Math.max(max[0], sumsf);
            return;
        }

        boolean newAChosess = !aChosess;
        if(aChosess) {
            optimalStratergyRecurr(arr, start + 1, end, max, sumsf + arr[start], newAChosess);
            optimalStratergyRecurr(arr, start, end - 1, max, sumsf + arr[end], newAChosess);
        } else {
            if(arr[start] > arr[end])
                optimalStratergyRecurr(arr, start + 1, end, max, sumsf, newAChosess);
            else
                optimalStratergyRecurr(arr, start, end - 1, max, sumsf, newAChosess);
        }
    }
}

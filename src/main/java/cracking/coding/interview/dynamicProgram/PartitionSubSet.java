package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 12/11/21.
 * https://www.youtube.com/watch?v=IiAsqfjhZnY&t=155s
 */
public class PartitionSubSet {


    public static void main(String[] args) {
        System.out.print(countFriendPair(4,2));
    }

    public static int countFriendPair(int num, int k) {
         int[][] dp = new int[num+1][k+1];

        for(int i = 1; i <= num; i++) {
            for(int j = 1; j <= k; j++) {

                if(i == 1 || j == 1) {
                    if ( j == 1) dp[i][j] = 1;

                }
                else if(i == 2) {
                    if( i <= j) {
                        dp[i][j] = 1;
                    }
                } else {
                    if ( i == j)
                        dp[i][j] = 1;
                    else
                        dp[i][j] = j*dp[i-1][j] + dp[i-1][j-1];
                }
            }
        }
        return dp[num][k];
    }
}

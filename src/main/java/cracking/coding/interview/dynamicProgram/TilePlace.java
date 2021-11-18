package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 31/10/21.
 */
public class TilePlace {

    public static void main(String[] args)
    {

        System.out.println(getPermutation(5));

        System.out.println(getPermutationNM(8, 3));
    }

    // Each tiles size is 2 X 1 and area is n X 2
    //f(n) = f(n-1) + f(n-2)
    private static int getPermutation(int n) {
        if(n == 1) {
            return 1;
        } else if( n <= 0) {
            return 0;
        }

        int[][] tilesWays = new int[2][n];


        for(int i = 0; i < n; i++) {

            if(i == 0) {
                tilesWays[0][i] = 0;
                tilesWays[1][i] = 1;
            } else if(i ==1) {
                tilesWays[0][i] = 1;
                tilesWays[1][i] = 1;
            } else {
                tilesWays[0][i] = tilesWays[0][i-2] + tilesWays[1][i-2];
                tilesWays[1][i] = tilesWays[0][i-1] + tilesWays[1][i-1];
            }
        }

        return tilesWays[0][n-1] + tilesWays[1][n-1];
    }

    // Each tiles size is m X 1 and area is n X m
    // f(n) = f(n-1) + f(n-m)
    private static int getPermutationNM(int n, int m) {
       if( n <= 0) {
            return 0;
       } else if ( n < m) {
           return 1;
       }

       int[] dp = new int[n+1];

       dp[1] = 1;

       for(int i = 2; i <=n ; i++) {

           if(i % m == 0 && dp[i-m] == 0) {
               dp[i] = dp[i - 1] + 1;
           } else if(i < m) {
               dp[i] = dp[i - 1];
           } else {
               dp[i] = dp[i - 1] + dp[i - m];
           }
       }


       return dp[n];
    }
}

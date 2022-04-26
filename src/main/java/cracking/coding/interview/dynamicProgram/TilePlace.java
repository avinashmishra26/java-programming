package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 31/10/21.
 */
public class TilePlace {

    public static void main(String[] args)
    {

        System.out.println(getPermutation(7));

        System.out.println(getPermutationNM(8, 3));
    }

    // Each tiles size is 2 X 1 and area is n X 2
    //f(n) = f(n-1) + f(n-2)
    private static int getPermutation(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i =3; i <=n ; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
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

       for(int i = 1; i <=n ; i++) {

           if(i < m) {
               dp[i] = 1;
           } else if(i == m) {
               dp[i] = 2;
           } else {
               dp[i] = dp[i - 1] + dp[i - m];
           }
       }


       return dp[n];
    }
}

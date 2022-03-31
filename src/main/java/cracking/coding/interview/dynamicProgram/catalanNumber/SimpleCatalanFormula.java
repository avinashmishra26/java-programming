package cracking.coding.interview.dynamicProgram.catalanNumber;

/**
 * Created by avinashkumarmishra on 30/03/22.
 *
 **/

public class SimpleCatalanFormula {

    public static void main(String[] args) {
        System.out.print(getCatalanNumber(5));
    }


    private static int getCatalanNumber(int n) {
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;


        for(int i = 2; i <=n; i++) {
            int t = 0;
            for(int j = 0; j < i; j++) {
                t += dp[j]*dp[i-j-1];
            }
            dp[i] = t;
        }
        return dp[n];
    }
}
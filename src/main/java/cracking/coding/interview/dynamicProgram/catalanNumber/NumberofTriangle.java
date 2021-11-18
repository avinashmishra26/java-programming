package cracking.coding.interview.dynamicProgram.catalanNumber;

/**
 * Created by avinashkumarmishra on 15/11/21.
 */
public class NumberofTriangle {

    public static void main(String[] args) {
        System.out.print(numberOfTriangleUsingPolygon(6));

    }

    private static int numberOfTriangleUsingPolygon(int n) {
        if(n < 1) return 0;

        int[] dp = new int[n-1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < dp.length; i++) {


            for(int j = 0; j < i ; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }

        return dp[n-2];

    }
}

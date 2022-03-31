package cracking.coding.interview.dynamicProgram.catalanNumber;

/**
 * Created by avinashkumarmishra on 14/11/21.
 * 2022
 */
public class NonIntersectingChords {

    public static void main(String[] args) {

        //remember here 2 points means 1 pair. so n/2
        System.out.print(cntNonIntersectingChords(4/2));
    }

    private static int cntNonIntersectingChords(int n) {

        int[] dp = new int[n+1];

        dp[0] = dp[1]= 1;

        for(int i = 2; i <=n; i++){

            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return  dp[n];
    }
}

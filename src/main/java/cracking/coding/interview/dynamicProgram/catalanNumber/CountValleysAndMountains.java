package cracking.coding.interview.dynamicProgram.catalanNumber;

import cracking.coding.interview.binarySearchtree.NumofTrees;

/**
 * Created by avinashkumarmishra on 14/11/21.
 * 2022
 */
public class CountValleysAndMountains {

    public static void main(String[] args) {
        System.out.print(getMountainValleys(4));
    }

    private static int getMountainValleys(int n) {

        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;

        for(int i = 2; i<=n; i++) {
            int cnt = 0;

            for(int j = 0; j < i; j++) {
                cnt += dp[j]*dp[i-j-1];
            }
            dp[i] = cnt;
        }

        return dp[n];
    }
}

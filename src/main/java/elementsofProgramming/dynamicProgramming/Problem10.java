package elementsofProgramming.dynamicProgramming;

import java.util.*;

/**
 * Created by avinashkumarmishra on 04/10/21.
 * COUNT THE NUMBER OF MOVES TO CLIMB STAIRS
 *
 */
public class Problem10 {

    static Map<Integer, Integer> cache = new HashMap<>();

    public static void main(String[] args) {

        System.out.println(climbStairs(5));

        System.out.println(getMoves(5, 2));


        System.out.println(numberOfWaysToTop(5, 2));
    }

    //Pure DP with tabulation method
    public static int climbStairs(int n) {

        int[] dp = new int[n+1];

        for ( int i = 0; i < dp.length ; i++) {
            if ( i == 0 ){
                dp[i] = 1;
            } else {
                if ((i - 1) >= 0) {
                    dp[i] += dp[i-1];
                }
                if ((i-2) >= 0) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

    //Pure DP with recursion
    public static int getMoves(int totalStairs, int stairsLimit) {

        if (totalStairs < 0) {
            return -1;
        } else if ( totalStairs == 0) {
            return 1;
        }
        int count = 0;
        if (!cache.containsKey(totalStairs)){

            for( int i = 1; i <= stairsLimit; i++) {
                if (Math.abs(totalStairs - i) >= 0) {
                    int v = getMoves(totalStairs - i, stairsLimit);
                    count = count + (v > 0 ? v : 0);
                }
            }

            cache.put(totalStairs, count);

        }
        return cache.get(totalStairs);
    }

    //EPI method
    public static int numberOfWaysToTop(int top, int maximumStep) {
        return computeNumberOfWaysToH (top , maximumStep, new int [top + 1]);
    }
    private static int computeNumberOfWaysToH(int n, int maximumStep,
                                              int[] numberOfWaysToH) {
        if (n <= 1) {
            return 1;
        }
        if (numberOfWaysToH[n] == 0) {
            for (int i = 1; i <= maximumStep && n - i >= 0; ++i) {
                numberOfWaysToH[n]
                        += computeNumberOfWaysToH(n - i, maximumStep, numberOfWaysToH);
            }
        }
        return numberOfWaysToH[n];
    }

}

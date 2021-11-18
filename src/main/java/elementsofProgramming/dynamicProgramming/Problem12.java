package elementsofProgramming.dynamicProgramming;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by avinashkumarmishra on 04/11/21.
 * FIND THE LONGEST NONDECREASING SUBSEQUENCE
 */
public class Problem12 {

    public static void main(String[] args) {

        System.out.println(longestIncreasingSubSequence(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9}));

        System.out.println(longestIncreasingSubSequencevalue(new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9}));
    }

    private static int longestIncreasingSubSequence(int[] arr) {

        Integer[] dp = new Integer[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            if ( i == 0 ) {
                dp[i] = 1;
            }

            else {
                int max = 0;
                for(int j = 0 ; j < i; j++) {
                    if ( arr[j] < arr[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + 1;
            }
        }

        return Collections.max(Arrays.asList(dp));
    }

    private static int longestIncreasingSubSequencevalue(int[] arr) {

        Integer[] dp = new Integer[arr.length];

        for(int i = 0 ; i < arr.length; i++) {
            if ( i == 0 ) {
                dp[i] = arr[i];
            }

            else {
                int max = 0;
                for(int j = 0 ; j < i; j++) {
                    if ( arr[j] < arr[i]) {
                        max = Math.max(max, dp[j]);
                    }
                }
                dp[i] = max + arr[i];
            }
        }

        return Collections.max(Arrays.asList(dp));
    }
}

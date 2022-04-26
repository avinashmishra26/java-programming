package programming.level2;

import java.util.ArrayList;

/**
 * Created by avinash on 18/04/2022.
 *
 * Print All Longest Increasing Subsequences Dynamic Programming
 */
public class Problem75 {




    public static void main(String[] args) {

        System.out.print(getLIS(new int[]{10,22, 9, 33, 21, 50, 41, 60, 80, 1}));
    }

    private static ArrayList<Integer> getLIS(int[] arr) {
        int[] dp = new int[arr.length];

        dp[0] = 1;
        int maxLIS = Integer.MIN_VALUE;

        for(int i = 1; i < arr.length; i++) {

            int tempMax = 0;

            for(int j = i-1; j >=0; j--) {
                if(arr[j] <= arr[i] ) {
                    tempMax = Math.max(dp[j], tempMax);
                }
            }
            dp[i] = tempMax+1;
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        return null;
    }
}

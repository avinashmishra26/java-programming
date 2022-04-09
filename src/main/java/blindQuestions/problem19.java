package blindQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by avinashkumarmishra on 10/10/21.
 *
 * Word Break - Dynamic Programming - Leetcode 139
 *
 */


public class problem19 {
    public static void main(String[] args) {
        String[] st = {"loves", "pep", "coding", "pepcoding", "ice", "cream", "icecream", "man", "go", "mango" };

        Set<String> dict = new HashSet<>();
        for (String s: st)
            dict.add(s);

        String pattern = "pepcodinglovesmangoicecream";

        System.out.print(getWordBreak(dict, pattern));


    }


    private static int getWordBreak(Set<String> dict, String val) {

        int[] dp = new int[val.length()];

        for ( int i = 0; i < val.length() ; i++ ) {
            int cnt = 0;
            if (dict.contains(val.substring(0,i+1)))
                    cnt++;

            for ( int j = i-1; j > 0; j--) {
                if (dict.contains(val.substring(j,i+1)) && dp[j-1] > 0) {
                    cnt += dp[j-1];
                }
            }
            dp[i] = cnt;

        }
        return dp[val.length()-1];
    }
}
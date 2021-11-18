package cracking.coding.interview.dynamicProgram;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by avinashkumarmishra on 10/10/21.
 */
public class MinimumWordBreakUsingDP {


    public static void main(String[] args) {
        String[] st = {"loves", "pep", "coding", "pepcoding", "ice", "cream", "icecream", "man", "go", "mango" };

        Set<String> dict = new HashSet<>();
        for (String s: st)
            dict.add(s);

        String pattern = "pepcodinglovesmangoicecream";
        for ( char a : pattern.toCharArray())
            System.out.print(a +" ");

        System.out.println();
        for ( int a : getTotalWordBreak(dict, pattern)) {

            System.out.print(a +" ");
        }

        System.out.println();
        System.out.println(getMinimumWordBreak(dict, pattern));
    }

    //TotalWordBreak
    private static int[] getTotalWordBreak(Set<String> dict, String val) {

       int[] dp = new int[val.length()];

       for ( int i = 0; i < val.length() ; i++ ) {
           if ( i == 0) {
               if (dict.contains(val.substring(i,i+1)))
                   dp[i] = 1;
           } else {
               int cnt = 0;
               for ( int j = 0; j <=i; j++) {
                   if (dict.contains(val.substring(j,i+1))) {
                       if ( j == 0) {
                           cnt++;
                       } else if(dp[j-1] > 0){
                           cnt += dp[j-1];
                       }
                   }
               }
               dp[i] = cnt;
           }
       }
        return dp;
    }

    //MinimumWordBreak
    private static int getMinimumWordBreak(Set<String> dict, String val) {

        int[] dp = new int[val.length()];

        for ( int i = 0; i < val.length() ; i++ ) {
            if ( i == 0) {
                if (dict.contains(val.substring(i,i+1)))
                    dp[i] = 1;
            } else {
                int cnt = Integer.MAX_VALUE;
                for ( int j = 0; j <=i; j++) {
                    if (dict.contains(val.substring(j,i+1))) {
                       if(j-1 >= 0){
                           if(dp[j-1] != 0)
                            cnt = Math.min(cnt,dp[j-1]+1);
                        } else {
                           cnt = 1;
                       }
                    }
                }
                dp[i] = cnt == Integer.MAX_VALUE ? 0 : cnt;
            }
        }
        return dp[val.length()-1];

    }



}

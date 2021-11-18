package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 09/11/21.
 */
public class LongestCommonSubsequenceNonContigous {

    public static void main(String[] args) {
        System.out.print(longestCommonSubsequenceNonContigous("pxyabcz","xyzabcp"));
    }

    public static int longestCommonSubsequenceNonContigous(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];
        int[] prevMatch = new int[text2.length()+1];

        int max = 0;

        for(int row = 0 ; row < dp.length; row++) {
            for(int col = 0 ; col < dp[0].length; col++) {
                if ( row == 0) {
                    dp[row][col] = 0;
                } else if(col == 0) {
                    dp[row][col] = 0;
                } else {

                    char t1 = text1.charAt(row - 1);
                    char t2 = text2.charAt(col - 1);

                    if(t1 == t2) {
                        dp[row][col] = 1 + dp[row-1][col-1];
                        max = Math.max(max, dp[row][col]);
                    } else {
                        dp[row][col] = 0;
                    }
                }
            }
        }

        return max;

    }
}

package programming.level2;

/**
 *  Created by avinashkumarmishra on 05/04/22.
 *
 *  Longest Palindromic Substring Dynamic Programming
 *
 *
 **/

public class Problem71 {

    public static void main(String[] args) {
        System.out.print(getLongestPalindrome("abccbc"));
    }


    private static int getLongestPalindrome(String s) {

        int max = Integer.MIN_VALUE;
        boolean[][] result = new boolean[s.length()][s.length()];

        for(int g = 0; g < s.length(); g++) {
            for(int i = 0, j= g; j < s.length(); i++, j++) {
                if( g == 0) {
                    result[i][j] = true;
                } else if( g == 1) {
                    result[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    result[i][j] = s.charAt(i) == s.charAt(j) && result[i+1][j-1];
                }
                if(result[i][j] && max < (j-i+1)) {
                    max = j - i +1;
                }
            }
        }
        return max;
    }
}
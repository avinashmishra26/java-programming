package programming.level2;

/**
 *  Created by avinashkumarmishra on 05/04/22.
 *
 *  Count Palindromic Substrings Dynamic Programming
 *  | Leetcode#647 Solution in JAVA
 *
 *
 **/


public class Problem70 {


    public static void main(String[] args) {
        System.out.print(getAllPalindrome("abccbc"));
    }


    private static int getAllPalindrome(String s) {

        int cnt = 0;
        boolean[][] results = new boolean[s.length()][s.length()];

        for(int g = 0; g < s.length(); g++) {

            for(int i =0, j = g; j < s.length(); i++, j++ ) {

                if( g == 0) {
                    results[i][j] = true;
                    cnt++;
                } else if(g == 1){
                    if(s.charAt(i) == s.charAt(j)) {
                        results[i][j] = true;
                        cnt++;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j) && results[i+1][j-1] == true) {
                        results[i][j] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
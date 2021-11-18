package cracking.coding.interview.dynamicProgram.substrings;

/**
 * Created by avinashkumarmishra on 09/11/21.
 */
public class PalindromeCount {

    public static void main(String[] args) {
        System.out.print(countPalindrome("abccbc"));
    }


    private static int countPalindrome(String input) {

        int[][] dp = new int[input.length()][input.length()];
        int totalPalindromes = 0;

        for(int g = 0; g < dp.length; g++) {

            for(int i = 0, j = g; j < dp.length; i++, j++){
                if(i == j){
                    dp[i][j] = 1;
                    totalPalindromes++;
                } else {
                    if (input.charAt(i) == input.charAt(j)){
                        if( i-g == 1) {
                            dp[i][j] = 1;
                            totalPalindromes++;
                        } else if(dp[i+1][j-1] == 1){
                            dp[i][j] = 1;
                            totalPalindromes++;
                        }
                    }
                }
            }
        }
        return totalPalindromes;
    }

}

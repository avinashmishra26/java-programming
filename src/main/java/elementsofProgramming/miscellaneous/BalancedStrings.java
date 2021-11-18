package elementsofProgramming.miscellaneous;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 03/10/21.
 * Greedy Approach to find number of terms(substrings) where R and L are balanced
 * "RLRRLLRLRL" => 4 { RL, RRLL, RL, RL}
 * "RLLLLRRRLR" => 3 { RL, LLLRRR, LR}
 */
public class BalancedStrings {

    public static void main(String[] args) {
        System.out.println(getBalacnedString("RLRRLLRLRL"));
        System.out.println(getBalacnedString("RLLLLRRRLR"));
        System.out.println(getBalacnedString("RLLLLRRRR"));
    }


    static int getBalacnedString(String str) {

        int res = 0;

        int firstCharCnt  = 0 , secondCharcnt = 0;
        char firstChar = '$', secondChar = '$';
        boolean changeDetected = false;

        for ( int i = 0; i < str.length() ; i++) {

            char c = str.charAt(i);

            if ( (changeDetected && firstChar == c) || (secondChar == c && secondCharcnt == firstCharCnt) ){
                res++;
                changeDetected = false;
                firstCharCnt  = secondCharcnt = 0;
                firstChar = secondChar = '$';
            }

            if (firstChar == '$' || firstChar == c) {
                firstChar = c;
                firstCharCnt++;
            } else if (secondChar == '$' || secondChar == c) {
                secondChar = c;
                secondCharcnt++;
                changeDetected = true;
            }

        }

        if (firstCharCnt > 0 && secondCharcnt > 0)
            res ++;

        return res;
    }
}

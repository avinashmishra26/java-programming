package cracking.coding.interview.backtracking;

/* Created by avinashkumarmishra on 22/03/22.
*  2022
*
*  PrintEncoding of Strings
*/

public class PrintEncoding {

    public static void main(String[] args) {
        printPermutation("2110935", 0, "");
    }



    private static void printPermutation(String num, int idx, String ssf) {

        if(idx == num.length()) {
            System.out.println(ssf);
            return;
        }

        int x = num.charAt(idx) - '0';
        if(x == 0) return;

        if(x != 0) {
            char c = (char)('a' + x - 1);
            printPermutation(num, idx+1, ssf+c);
        }

        if(idx+1 == num.length()) return;

        int x1 = num.charAt(idx+1) - '0';

        int xmulx1 = x*10+x1;

        if (xmulx1 < 26) {
            char c = (char)('a' + xmulx1 - 1);
            printPermutation(num, idx+2, ssf+c);
        }



    }

}
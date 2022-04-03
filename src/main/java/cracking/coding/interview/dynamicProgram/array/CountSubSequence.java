package cracking.coding.interview.dynamicProgram.array;

/* Created by avinashkumarmishra on 31/03/22.
*
*  Subsequence of Strings
*
*  Number of sub-sequence where we can see
*  a+b+c+(a followed by b and b followed by c)
*/

public class CountSubSequence {

    public static void main(String[] args) {
        System.out.print(getSubsequence("abcabc"));
    }

    private static int getSubsequence(String s) {

        int a = 0;
        int ab = 0;
        int abc = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(c == 'a') {
                a = 2*a + 1;
            } else if( c == 'b') {
                ab = 2*ab + a;
            } else if( c == 'c') {
                abc = 2*abc + ab;
            }

        }
        return abc;
    }
}
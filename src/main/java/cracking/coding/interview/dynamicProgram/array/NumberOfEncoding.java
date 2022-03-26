package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * 2022
 *
 * Decode ways where
 * 1-a
 * .....
 * 26-z
 *
 *
 */
public class NumberOfEncoding {


    public static void main(String[] args) {
        System.out.print(getEncoding("231011"));

    }

    public static int getEncoding(String val) {

        char[] c = val.toCharArray();
        int[] dp = new int[c.length+1];


        for(int i = 0; i< c.length+1; i++) {
            if (i ==0){
                dp[i] = 1;
            }
            else if (i ==1){
                int r = c[i-1] - '0';
                if ( r > 0 && r <= 9)
                    dp[i] = dp[i-1];
            } else {
                int r = c[i-1] - '0';
                int p_r = (c[i-2] - '0')*10 + r;
                if(r > 0 && r <= 9) {
                    dp[i] = dp[i-1];
                }
                if (p_r >= 10 && p_r <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }

        return dp[c.length];
    }
}

package cracking.coding.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * Count Binary Strings | Binary Strings with no consecutive 0's | Dynamic Programming
 */
public class BinaryStringsWithNoConsecutiveZeros {

    public static void main(String[] args) {

        System.out.println(getBSCount(5));


        //print all the combinations
        EndingBinary ze = new EndingBinary(0);
        ze.res.add(new StringBuilder("0"));

        EndingBinary on = new EndingBinary(1);
        on.res.add(new StringBuilder("1"));

        display(5, 1, ze, on);
    }

    public static int getBSCount(int strLength) {
        int[][] dp = new int[strLength][2];

        for( int i = 0; i< strLength; i++) {
            if( i == 0){
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] =  dp[i-1][1];
                dp[i][1] = dp[i-1][0] + dp[i-1][1];
            }
        }

        return dp[strLength-1][0] + dp[strLength-1][1];

    }

    private static class EndingBinary {
        int i;
        List<StringBuilder> res = new ArrayList<>();

        EndingBinary(int n) {
            this.i = n;
        }
    }

    // print all the combinations display(5, 1, new EndingBinary(0), new EndingBinary(1))
    public static void display(int strLength, int comtLength, EndingBinary zero, EndingBinary ones) {

        if ( strLength == comtLength) {
           for(StringBuilder s : zero.res) {
               System.out.println(s);
           }

           for(StringBuilder s : ones.res) {
                System.out.println(s);
           }
           return;
        }

        List<StringBuilder> zerosList = new ArrayList<>();
        List<StringBuilder> onesList = new ArrayList<>();

        for(StringBuilder s : ones.res) {
            zerosList.add(new StringBuilder(s+"0"));
            onesList.add(new StringBuilder(s+"1"));
        }

        for(StringBuilder s : zero.res) {
            onesList.add(new StringBuilder(s+"1"));
        }

        zero.res = zerosList;

        ones.res = onesList;

        display(strLength, comtLength+1, zero, ones);

    }
}

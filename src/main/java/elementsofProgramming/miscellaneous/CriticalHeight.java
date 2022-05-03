package elementsofProgramming.miscellaneous;

/**
 * Created by avinashkumarmishra on 05/10/21.
 *
 * Egg Drop Problem
 *   You need to test the design of a protective case. Specifically, the case can protect
 *   the enclosed device from a fall from up to some number of floors, and you want to
     determine what that number of floor. You can assume the following:
     • All cases have identical physical properties. In particular, if one breaks when
     falling from a particular level, all of them will break when falling from that
     level.
     • A case that survives a fall can be used again, and a broken case must be dis¬
     carded.
     • If a case breaks when dropped, then it would break if dropped from a higher
     floor, and if a case survives a fall, then it would survive a shorter fall.
 */
public class CriticalHeight {

    public static void main(String[] args) {
        System.out.println(getCriticalHeight(3, 7));

        System.out.print(getCriticalHeight(2, 6));

    }

    // Egg Drop Problem
    public static int getCriticalHeight(int eggs, int floors) {
        int[][] dp = new int[eggs+1][floors+1];

        //System.out.println(dp[0][0]);

        for ( int e = 1; e <= eggs; e++) {
            for ( int f = 1; f <= floors; f++) {
                if( e == 1) {
                    dp[e][f] = f;
                } else if ( f == 1) {
                    dp[e][f] = 1;
                } else {
                    dp[e][f] = 1 + getMinVal(dp, e-1, e, f-1);
                }
            }
        }
        return dp[eggs][floors];
    }

    private static int getMinVal(int[][] dp, int firstRow, int secondRow, int endIndex) {
        int i = 0;
        int minV = Integer.MAX_VALUE;
        while( endIndex >= 0) {
            int val = Math.max(dp[firstRow][i], dp[secondRow][endIndex]);
            i++;
            endIndex--;
            minV = Math.min(minV, val);
        }
        return minV;
    }
}

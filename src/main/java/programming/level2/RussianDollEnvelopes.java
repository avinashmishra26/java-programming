package programming.level2;

import java.util.Arrays;

/**
 * Created by avinash on 24/04/2022.
 *
 * https://leetcode.com/problems/russian-doll-envelopes/
 *
 * One envelope can fit into another if and only if both the width
 * and height of one envelope are greater than the other envelope's width and height.
 */
public class RussianDollEnvelopes {

    public static void main(String[] args) {

        //best time
        maxEnvelopes(new int[][]{{5,4},{6,4},{6,7},{2,3}});
    }

    private static class Envelope implements Comparable<Envelope> {
        int width;
        int height;

        public Envelope(int w, int h) {
            this.width = w;
            this.height = h;
        }

        @Override
        public int compareTo(Envelope other) {
            return this.width - other.width;
        }
    }

    private static int getMaxEnvelopTogether(int[][] envelopes) {


        Arrays.sort(envelopes, (a, b) -> Integer.compare(a[0],b[0]));

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int overallMax = Integer.MIN_VALUE;

        for(int i = 1; i < envelopes.length; i++) {

            int cnt = 0;

            for(int j = 0; j < i; j++) {

                if(envelopes[j][1] < envelopes[i][1] && envelopes[j][0] < envelopes[i][0]) {
                    cnt = Math.max(cnt, dp[j]);
                }
            }
            dp[i] = cnt + 1;
            overallMax = Math.max(overallMax, dp[i]);
        }
        return overallMax;
    }


    //best time comlexity
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) {
                return a[0] - b[0];
            }

            return b[1] - a[1];
        });

        int[] tops = new int[envelopes.length];
        int numPiles = 0;
        for(int i = 0; i < tops.length; i++) {
            int height = envelopes[i][1];

            // find pile
            int pile = Arrays.binarySearch(tops, 0, numPiles, height);
            if(pile < 0) {
                pile = -(pile + 1);
            }

            // update pile top height
            tops[pile] = height;

            // if pile == numPiles, means it's out of index
            if(pile == numPiles) {
                numPiles++;
            }
        }

        return numPiles;
    }

}

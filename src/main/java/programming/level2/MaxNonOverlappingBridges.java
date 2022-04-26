package programming.level2;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 10/11/21.
 *
 * Sort on basis of one side and then apply LIS(longest increasing sub sequence) on the other side
 * 2022
 */
public class MaxNonOverlappingBridges {

    public static void main(String[] args) {

        Bridge[] bridges = new Bridge[10];
        bridges[0] = new Bridge(10,20);
        bridges[1] = new Bridge(2,7);
        bridges[2] = new Bridge(8,15);
        bridges[3] = new Bridge(17,3);
        bridges[4] = new Bridge(21,40);
        bridges[5] = new Bridge(50,4);

        bridges[6] = new Bridge(51,57);
        bridges[7] = new Bridge(60,80);
        bridges[8] = new Bridge(80,90);
        bridges[9] = new Bridge(1,30);

        Arrays.sort(bridges);

        System.out.print(maxNonOverlappingBridge(bridges));


    }

    private static class Bridge implements Comparable<Bridge> {
        int north;
        int south;

        Bridge(int n, int s) {
            this.north = n;
            this.south = s;
        }

        public int compareTo(Bridge b) {
            if(this.north != b.north) {
                return this.north - b.north;
            } else { // it will solve when we have 2 bridges having starting or ending position at the same point
                return this.south - b.south;
            }
        }
    }


    private static int maxNonOverlappingBridge(Bridge[] south) {

        int[] dp = new int[south.length];
        int maxOverall = Integer.MIN_VALUE;

        for(int i = 0; i < south.length; i++) {

            int max = 0;
            for(int j = 0; j < i; j++){
                if( south[i].south > south[j].south) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
            if(maxOverall < dp[i]) {
                maxOverall = dp[i];
            }
        }
        return maxOverall;
    }
}

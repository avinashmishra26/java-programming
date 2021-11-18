package elementsofProgramming.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 26/10/21.
 */
public class MaximumSumCircularSubarray {

    public static void main(String[] args) {
        int[] n= { 4, 6,-2, 1, -5, 3 };
        System.out.print(getMinSubSequence(n));
    }

    private static int getMinSubSequence(int[] nums) {
        int minSofar = Integer.MAX_VALUE, currentMin = 0;

        int maxSoFar = Integer.MIN_VALUE, currentMax = 0;

        int total = 0;

        for( int i = 0; i < nums.length; i++) {
            currentMin += nums[i];

            currentMax += nums[i];

            total += nums[i];

            if(currentMin > nums[i]) {
                currentMin = nums[i];
            }


            if(minSofar  > currentMin) {
                minSofar = currentMin;
            }

            //MAX
            if(currentMax < nums[i]) {
                currentMax = nums[i];
            }

            if(maxSoFar  < currentMax) {
                maxSoFar = currentMax;
            }
        }


        return Math.max(maxSoFar, total-minSofar);
    }
}

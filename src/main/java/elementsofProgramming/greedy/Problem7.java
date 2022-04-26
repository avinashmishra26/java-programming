package elementsofProgramming.greedy;

import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 03/10/21.
 * COMPUTE THE MAXIMUM WATER TRAPPED BY A PAIR OF VERTICAL LINES
 * 2022
 */
public class Problem7 {

    public static void main(String[] args) {
        System.out.print(getMaxTrappedWater(Arrays.asList(1,2,1,3,4,4,5,6,2,1,3,1,3,2,1,2,4,1)));
    }

    public static int getMaxTrappedWater(List<Integer> heights) {

       int maxWaterTrapped = Integer.MIN_VALUE;

        for( int i = 0, j= heights.size()-1; i < j; ) {
            int tempWaterTrapped = Math.min(heights.get(i) , heights.get(j)) * Math.abs(j-i);
            if (tempWaterTrapped > maxWaterTrapped) {
                maxWaterTrapped = tempWaterTrapped;
            }

            if ( heights.get(i) > heights.get(j) ) {
                j -= 1;
            } else if (heights.get(i) < heights.get(j)) {
                i += 1;
            } else {
                i++;
                j--;
            }
        }

        return maxWaterTrapped;
    }
}

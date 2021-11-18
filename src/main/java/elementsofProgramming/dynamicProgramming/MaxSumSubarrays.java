package elementsofProgramming.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by avinashkumarmishra on 27/09/21.
 * find the maximum sum over all subarrays of a given array of integer
 *
 */
public class MaxSumSubarrays {


    public static void main(String[] args) {
        System.out.println(maxSubArraySum(Arrays.asList(904, 40, 523, 12, -335, -385, -124, 481, -31)));

        System.out.println(maxSubArraySumKandane(Arrays.asList(904, 40, 523, 12, -335, -385, -124, 481, -31)));

        System.out.println(maxSubArraySumKandane(Arrays.asList(-2, -3, 4, -1, -2, 1, 5, -3)));

    }

    // Brute Force has 0(n^3) time complexity
    static int maxSubArraySum(List<Integer> list) {

        int max = Integer.MIN_VALUE;


        for (int i = 0; i< list.size() ; i++) {

            for ( int j=i ; j < list.size(); j++ ) {

                int sum = 0;
                for ( int k=i ; k <= j; k++ ) {
                    sum += list.get(k);
                }

                if (max < sum ) {
                    max = sum;
                }
            }
        }

        return max;
    }

    //Kandane Algorithm o(n)
    static int maxSubArraySumKandane(List<Integer> list) {

        int maxSoFar = Integer.MIN_VALUE, currentMax = 0;

        for(int i = 0; i< list.size(); i++) {

            currentMax += list.get(i);

            if (list.get(i) > currentMax) {
                currentMax = list.get(i);
            }

            if (maxSoFar < currentMax) {
                maxSoFar = currentMax;
            }


        }

        return maxSoFar;
    }
}

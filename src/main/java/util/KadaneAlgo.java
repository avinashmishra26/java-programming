package util;

/**
 * Created by avinashkumarmishra on 25/10/21.
 */
public class KadaneAlgo {

    public static void main(String[] args) {
        System.out.println(maxSubarray(new int[]{4, -5, 3, -1, 3, -6, 4}));


        System.out.print(maxSubarray(new int[]{5, -3, 5}));
    }


    public static int maxSubarray(int[] nums) {
        int maxCurrent = 0, maxSoFar = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {

            maxCurrent += nums[i];

            if(maxCurrent < nums[i]) {
                maxCurrent = nums[i];
            }

            if (maxSoFar < maxCurrent) {
                maxSoFar = maxCurrent;
            }
        }
        return maxSoFar;
    }

    public static int maxSubarraySumCirCular(int[] nums) {
        int maxCurrent = 0, maxSoFar = Integer.MIN_VALUE;
        int i = 0;
        for(int j = 0; j < 2*nums.length; j++) {
            i = j % nums.length;

            maxCurrent += nums[i];

            if(maxCurrent < nums[i]) {
                maxCurrent = nums[i];
            }

            if (maxSoFar < maxCurrent) {
                maxSoFar = maxCurrent;
            }
        }
        return maxSoFar;
    }
}

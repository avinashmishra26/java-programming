package blindQuestions;


/**
 *
 * Window stratergy
 *
 * Maximum Subarray
 * Leetcode 53
 *
 */

public class Problem53 {

    public int maxSubArray(int[] nums) {

        int maxSofar = Integer.MIN_VALUE, maxCurrent = 0 ;

        for(int i = 0; i < nums.length; i++) {

            maxCurrent += nums[i];

            if(maxCurrent < nums[i]) {
                maxCurrent = nums[i];
            }

            if(maxSofar < maxCurrent) {
                maxSofar = maxCurrent;
            }
        }
        return maxSofar;
    }
}
package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 17/11/21.
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarray {

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,3,-2,4,-1,-12}));

        System.out.println(getMaxProduct(new int[]{2,3,-2,4,-1,-12}));
    }

    public static int maxProduct(int[] nums) {

        int currMax = 1, currMin = 1, res = Integer.MIN_VALUE;

        for(int n : nums) {
            if( n == 0) {
                res = Math.max(res, 0);
                currMax = 1;
                currMin = 1;
                continue;
            }

            int tempMax = currMax*n;

            currMax = Math.max(tempMax, Math.max(currMin*n, n));

            currMin = Math.min(tempMax, Math.min(currMin*n, n));

            res = Math.max(res, currMax);
        }
        return res;
    }

    //second method
    public static int getMaxProduct(int[] nums) {
        int res = Integer.MIN_VALUE;
        int cprod = 1;

        for(int i = 0; i < nums.length; i++) {
            cprod *= nums[i];
            res = Math.max(res, cprod);
            if(nums[i] == 0) {
                cprod = 1;
            }
        }


        cprod = 1;
        for(int i = nums.length-1; i >= 0; i--) {
            cprod *= nums[i];
            res = Math.max(res, cprod);
            if(nums[i] == 0) {
                cprod = 1;
            }
        }

        return res;
    }
}

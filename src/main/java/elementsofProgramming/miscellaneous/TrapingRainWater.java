package elementsofProgramming.miscellaneous;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 28/10/21.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 *
 * https://leetcode.com/problems/trapping-rain-water
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * 2022
 */
public class TrapingRainWater {

    public static void main(String[] args) {
        System.out.println(getRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        System.out.println(getTRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));


        // compelxity n^2
        System.out.println(getWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));

        //best O(1)

    }

    private static int getRainWater(int[] nums){

        int totalWater = 0;

        Deque<Integer> stack = new LinkedList<>();
        int lefttMax = -1, rightMax =  -1;
        for(int i = 0; i < nums.length; ) {

            if(!stack.isEmpty() && nums[stack.peekLast()] < nums[i]){
                rightMax = nums[i];
                int elementHeight = nums[stack.removeLast()];
                if(!stack.isEmpty()) {
                    lefttMax = nums[stack.peekLast()];;
                }
                if(lefttMax != -1) {
                    totalWater += ( (Math.min(lefttMax, rightMax) - elementHeight)*(i - stack.peekLast() - 1) );
                }
                lefttMax = -1;
                continue;
            }

            stack.add(i);
            i++;
        }

        return totalWater;

    }

    private static int getTRainWater(int[] nums) {

        int water = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);

        for(int i = 1; i < nums.length; i++) {

            while(nums[deque.peekLast()] < nums[i]) {
                int currentHeigtIdx = deque.removeLast();
                int rightIdx = i;
                if(deque.isEmpty()) break;

                int leftIdx = deque.peekLast();

                water += ((Math.min(nums[leftIdx], nums[rightIdx]) - nums[currentHeigtIdx]) * (rightIdx-leftIdx-1));

            }
            deque.addLast(i);

        }
        return water;

    }

    //complexity with n2
    private static int getWater(int[] arr) {

        int water = 0;

        for(int i = 0; i < arr.length; i++) {
            int leftIdx = -1;
            int leftMax = Integer.MIN_VALUE;

            int rightIdx = arr.length;
            int rightMax = Integer.MIN_VALUE;

            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i] && arr[j] > leftMax) {
                    leftMax = arr[j];
                    leftIdx = j;
                }
            }

            for(int k = i+1; k < arr.length; k++) {
                if(arr[k] > arr[i] && arr[k] > rightMax) {
                    rightMax = arr[k];
                    rightIdx = k;
                }
            }

            if(leftIdx == -1 || rightIdx == arr.length) continue;

            int t = Math.min(leftMax, rightMax);

            water += (t-arr[i]);

        }
        return water;

    }
}

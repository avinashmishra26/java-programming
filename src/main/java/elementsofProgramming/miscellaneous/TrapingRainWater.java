package elementsofProgramming.miscellaneous;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 28/10/21.
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 * https://leetcode.com/problems/trapping-rain-water
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 */
public class TrapingRainWater {

    public static void main(String[] args) {
        System.out.print(getRainWater(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
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
}

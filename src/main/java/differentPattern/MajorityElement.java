package differentPattern;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by avinashkumarmishra on 21/02/22.
 *
 *  Boyer Moore voting algorithm is used to find the majority element among
 *  the given sequence of elements which occurs more than N/2 times, in linear time complexity and constant space complexity.
 *
 *  https://leetcode.com/problems/majority-element/
 *
 **/

public class MajorityElement {

    public static void main(String[] args) {
        System.out.print(majorityElement(new int[]{3,2,3}));
    }

    public static int majorityElement(int[] nums) {

        int count = 1;
        int majorElement = nums[0];

        for(int i = 1; i < nums.length ; i++) {

            if(nums[i] == majorElement) count++;
            else {
                count--;
                if (count == 0) {
                    count = 1;
                    majorElement = nums[i];
                }
            }
        }
        return majorElement;
    }
}
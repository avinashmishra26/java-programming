package programming.level2.arrayAndString;

/**
 * Created by avinash on 23/04/2022.
 * https://leetcode.com/problems/majority-element-ii/
 *
 */

import java.util.*;

public class MajorityElement_2 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

        //System.out.println(majorityElement(new int[]{1,1,1,2,2,2,3,3}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        int val1 = nums[0];
        int cnt1 = 1;

        int val2 = nums[0];
        int cnt2 = 0;

        for(int i = 1; i < nums.length; i++) {
            if(val1 == nums[i]) {
                cnt1++;
            } else if ( val2 == nums[i]) {
                cnt2++;
            } else {
                if(cnt1 == 0) {
                    val1 = nums[i];
                    cnt1 = 1;
                } else if(cnt2 == 0) {
                    val2 = nums[i];
                    cnt2 = 1;
                } else {
                    cnt1--;
                    cnt2--;
                }
            }
        }
        int totalLen = nums.length/3;
        List<Integer> res = new ArrayList();
        if(cnt1 == cnt2 && cnt1 == 0) return res;

        //check if val1 > 0 have frequency > n/3
        int freq1 = 0;
        int freq2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(val1 == nums[i]) {
                freq1++;
            }else if(val2 == nums[i]) {
                freq2++;
            }
        }
        if(freq1 > totalLen) {
            res.add(val1);
        }
        if(freq2 > totalLen) {
            res.add(val2);
        }
        return res;
    }
}

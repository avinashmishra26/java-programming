package programming.level2.arrayAndString;

/**
 * Created by avinash on 23/04/2022.
 * https://leetcode.com/problems/majority-element/
 *
 */
public class MajorityElement_1 {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{2,2,1,1,1,2,2}));

        System.out.println(majorityElement(new int[]{1,1,1,2,2,2,3,3}));
    }

    public static int majorityElement(int[] nums) {
        int val = nums[0], cnt = 1;

        for(int i = 1; i < nums.length; i++) {
            if(val == nums[i]) {
                cnt++;
            } else {
                cnt--;
                if(cnt < 0) {
                    val = nums[i];
                    cnt = 1;
                }
            }
        }
        //this will work if it is guranteed that we have a answer otherwise it will fail
        return val;
    }
}

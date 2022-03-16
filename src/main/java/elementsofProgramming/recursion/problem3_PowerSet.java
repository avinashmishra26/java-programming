package elementsofProgramming.recursion;

/**
 * Created by avinashkumarmishra on 13/10/21.
 * 2022
 */
public class problem3_PowerSet {

    public static void main(String[] args) {
        generatePowerSet(new int[]{1,2,3}, 0, "");
    }

    static void generatePowerSet(int[] nums, int idx, String start) {

        if(idx == nums.length) {
            System.out.print("{"+start +"} ");
            return;
        }

        generatePowerSet(nums, idx+1, start);
        generatePowerSet(nums, idx+1, start+nums[idx]);
    }
}

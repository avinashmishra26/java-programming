package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 13/11/21.
 *
 * https://leetcode.com/problems/delete-and-earn/
 *
 *
 * MaxNonAdjacentSum : Type 2, very similar :
 * 2022
 *
 */
public class DeleteAndEarn {

    public static void main(String[] args) {
        System.out.print(deleteAndEarn(new int[]{2,2,3,3,3,4 }));

    }

    private static int deleteAndEarn(int[] nums) {

        int[] count = new int[10001];

        for(int i = 0; i < nums.length; i++) {
            count[nums[i]] = count[nums[i]]+1;
        }

        //applying max sum of non-adjacent elements stratergy
        int include = count[0];
        int exclude = 0;

        for(int i = 1; i < count.length; i++) {
            int newInclude = exclude + i*count[i];
            exclude = Math.max(include, exclude);
            include = newInclude;
        }

        return Math.max(include, exclude);
    }
}

package cracking.coding.interview.dynamicProgram.differentType;

/**
 * Created by avinashkumarmishra on 13/11/21.
 */
public class MaxNonAdjacentSum {

    public static void main(String[] args) {
        System.out.print(maxSumofNonAdjacent(new int[]{30, 4, 2}));

    }

    //Not similar to House Robber Problem becoz it can deal with negative values
    private static int maxSumofNonAdjacent(int[] nums) {
        int include = nums[0];
        int exclude = 0;

        for(int i = 1; i < nums.length; i++) {
            int newInclude = exclude+ nums[i];

            exclude = Math.max(include, exclude);
            include = newInclude;
        }

        return Math.max(include, exclude);

    }
}

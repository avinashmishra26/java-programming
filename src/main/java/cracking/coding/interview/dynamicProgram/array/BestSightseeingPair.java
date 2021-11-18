package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 18/11/21.
 *
 * https://leetcode.com/problems/best-sightseeing-pair/
 *
 * Input: values = [8,1,5,2,6]
 Output: 11
 Explanation: i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11

 */
public class BestSightseeingPair {

    public static void main(String[] args) {
        System.out.print(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));

    }

    public static int maxScoreSightseeingPair(int[] values) {

        int max = Integer.MIN_VALUE;
        int maxCurrent = values[0] + 0;
        int res = -1;

        for(int i = 1; i < values.length; i++) {
            res = Math.max(res, maxCurrent + values[i] -i);
            maxCurrent = Math.max(maxCurrent, values[i] +i);
        }

        return res;
    }
}

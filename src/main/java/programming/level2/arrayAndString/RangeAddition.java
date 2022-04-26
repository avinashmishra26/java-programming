package programming.level2.arrayAndString;

/**
 * Created by avinash on 19/04/2022.
 *
 *
 * Assume you have an array of length n initialized with all 0’s and are given k update operations.
 *
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of
 * subarray A[startIndex … endIndex] (startIndex and endIndex inclusive) with inc.
 *
 * Return the modified array after all k operations were executed.
 * https://leetcode.com/problems/range-addition/
 * Given:

         length = 5,
         updates = [
         [1,  3,  2],
         [2,  4,  3],
         [0,  2, -2]
         ]

         Output:

         [-2, 0, 3, 5, 3]
 *
 *
 */
public class RangeAddition {


    public static void main(String[] args) {

        int[] result = rangeAddition(5, new int[][]{ {1,3,2}, {2, 4, 3}, {0, 2, -2} });

        for(int r : result) {
            System.out.print(r + " ");
        }
    }

    // O(q + n) => q = query and n = length
    private static int[] rangeAddition(int length, int[][] updates) {

        int res[] = new int[length];

        for(int[] update: updates) {
            res[update[0]] += update[2];
            if( (update[1] + 1) < res.length) {
                res[update[1] + 1] -= update[2];
            }
        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;

    }
}

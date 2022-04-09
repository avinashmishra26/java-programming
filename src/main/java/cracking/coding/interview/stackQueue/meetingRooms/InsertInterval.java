package cracking.coding.interview.stackQueue.meetingRooms;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 02/04/22.
 *
 * MergeOverlappingInterval : Use stack
 *
 *
 * https://leetcode.com/problems/insert-interval/
 *
 */


public class InsertInterval {


    public static void main(String[] args) {
        int[][] res = insert(new int[][]{
                {1,12},{14,19},{22,28}},new int[]{12,23});

        for(int[] r : res) {
            System.out.println(r[0] + "  " +r[1]);
        }

        System.out.println("New");
        res = insert(new int[][]{
                {9,12},{14,19},{22,28}},new int[]{0,5});

        for(int[] r : res) {
            System.out.println(r[0] + "  " +r[1]);
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

        boolean isIntervalMerged = false;
        Stack<int[]> stk = new Stack();

        for(int[] interval : intervals) {

            int[] curr = interval;

            if(isIntervalMerged == false) {

                if(curr[1] >= newInterval[0]) {
                    isIntervalMerged = true;

                    if(curr[0] > newInterval[0] && curr[0] > newInterval[1]) {
                        stk.push(newInterval);
                        stk.push(curr);
                    } else {

                        stk.push(new int[]{Math.min(newInterval[0],curr[0]), Math.max(newInterval[1],curr[1])});
                    }

                } else {
                    stk.push(curr);
                }


            } else if(isIntervalMerged == true) {

                int[] prev = stk.peek();

                if(prev[1] >= curr[0]) {
                    prev = stk.pop();
                    stk.push(new int[]{prev[0], Math.max(prev[1],curr[1])});
                } else {
                    stk.push(curr);
                }
            }

        }
        if(isIntervalMerged == false) {

            stk.push(newInterval);
        }

        return stk.toArray(new int[stk.size()][]);

    }
}
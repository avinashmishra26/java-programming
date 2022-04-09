package cracking.coding.interview.stackQueue.meetingRooms;


import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 03/04/22.
 *
 * MergeOverlappingInterval : Use stack
 *
 *
 * https://leetcode.com/problems/meeting-rooms/
 * LeetCode 252
 */


public class MeetingRoom1 {


    public static void main(String[] args) {

        boolean res = isMeetingPossible(new int[][]{
                    {1,12},{14,19},{22,28}});

        System.out.println(res);


        res = isMeetingPossible(new int[][]{
                {1,12},{11,19},{22,28}});

        System.out.println(res);

    }

    private static boolean isMeetingPossible(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));


        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i-1][1]) {
                return false;
            }
        }

        return true;

    }
}
package cracking.coding.interview.stackQueue.meetingRooms;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by avinashkumarmishra on 03/04/22.
 *
 * MergeOverlappingInterval : Use stack
 *
 *
 * https://leetcode.com/problems/meeting-rooms-ii/
 *  LeetCode 253
 *
 */

public class MeetingRoom2 {

    public static void main(String[] args) {

        System.out.println(numberOfMeetingRooms(new int[][]{
                {1,12},{14,19},{22,28}}));

        System.out.println(numberOfMeetingRooms(new int[][]{
                {1,12},{5,13},{14,19},{22,28}}));
    }

    private static int numberOfMeetingRooms(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        //Comparator<int[]> cm = (a, b) -> Integer.compare(a[1],b[1]);

        PriorityQueue<int[]> pr = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < intervals.length; i++) {
            if(pr.size() > 0 && pr.peek()[1] <= intervals[i][0]) {
                pr.remove();
                pr.add(intervals[i]);
            } else {
                pr.add(intervals[i]);
            }

        }
        return pr.size();
    }
}
package cracking.coding.interview.stackQueue.meetingRooms;

import java.util.*;

/**
 * Created by avinashkumarmishra on 02/04/22.
 *
 * MergeOverlappingInterval : Use stack
 *
 *
 * https://leetcode.com/problems/merge-intervals/
 *
 */

public class MergeOverlappingInterval {

    public static void main(String[] args) {

        ArrayList<MeetingInterval> lst = new ArrayList<>(Arrays.asList( new MeetingInterval(1,8),
                new MeetingInterval(5, 12),
                new MeetingInterval(14,19),
                new MeetingInterval(22, 28),
                new MeetingInterval(25, 27)));


        int[][] res = mergeIntervals(new int[][]{ {1,8},{5,12},{14,19},{22,28},{25,27}});

        System.out.print("\n New");
        Stack<MeetingInterval> m = getMergeInterval(lst);
        while (m.size() >0 ) {
            System.out.print(m.pop());
        }
    }

    private static class MeetingInterval implements Comparable<MeetingInterval>{
        int start;
        int end;

        MeetingInterval(int s, int e) {
            this.start = s;
            this.end = e;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }

        @Override
        public int compareTo(MeetingInterval o) {
            return start - o.start;
        }

        @Override
        public String toString(){
            return "( "+start +" : " + end +" )";
        }
    }

    private static int[][] mergeIntervals(int[][] intervals) {


        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));


        Stack<int[]> stk = new Stack<int[]>();

        for(int[] interval : intervals) {

            int[] curr = interval;

            if(stk.size() > 0) {

                int[] prev = stk.peek();

                if(curr[0] <= prev[1]) {
                    prev = stk.pop();

                    stk.push(new int[]{prev[0], Math.max(curr[1], prev[1])});
                } else {
                    stk.push(curr);
                }


            } else {
                stk.push(curr);
            }



        }

        intervals = new int[stk.size()][2];

        for(int i = intervals.length-1; i >= 0; i--) {
            int[] t = stk.pop();
            intervals[i][0] = t[0];
            intervals[i][1] = t[1];
        }
        return intervals;
    }

    //using stack and it has space complexity of o(n)
    private static Stack<MeetingInterval> getMergeInterval(ArrayList<MeetingInterval> meetings){

        Collections.sort(meetings);

        Stack<MeetingInterval> res = new Stack<>();

        for(MeetingInterval meet : meetings) {

            if(res.size() > 0  && meet.start < res.peek().end) {
                MeetingInterval first = res.pop();
                res.push(new MeetingInterval(first.start, Math.max(first.end, meet.end)));
            } else {
                res.push(meet);
            }

        }
        Stack<MeetingInterval> r= new Stack<>();

        while (res.size() > 0) {
            r.push(res.pop());
        }

        return r;
    }
}
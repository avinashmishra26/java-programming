package cracking.coding.interview.stackQueue;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by avinashkumarmishra on 02/04/22.
 *
 * MergeOverlappingInterval
 *
 * Can also use using stack
 *
 */

public class MergeOverlappingInterval {

    public static void main(String[] args) {

        ArrayList<MeetingInterval> lst = new ArrayList<>(Arrays.asList( new MeetingInterval(1,8),
                new MeetingInterval(5, 12),
                new MeetingInterval(14,19),
                new MeetingInterval(22, 28),
                new MeetingInterval(25, 27)));


        mergeIntervals(lst).stream().forEach(System.out :: println);

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

    private static List<MeetingInterval> mergeIntervals(ArrayList<MeetingInterval> meetings) {

        Collections.sort(meetings);

        for(int i = meetings.size() - 1; i > 0; i-- ) {

            if(meetings.get(i).start <= meetings.get(i-1).end) {
                MeetingInterval toBRemoved =  meetings.get(i);

                if(meetings.get(i).end < toBRemoved.end) {
                    meetings.set(i-1, new MeetingInterval(meetings.get(i-1).start, toBRemoved.end));
                }
                meetings.remove(toBRemoved);
            }
        }
        return meetings;
    }

    //using stack but it has more space complexity
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
package amazon;

import java.util.*;

/**
 * Created by avinashkumarmishra on 18/11/21.
 */
public class Promlem1 {

    private static class Person {
        List<Time> meetingTime;
    }

    private static class Time implements Comparable<Time>{
        int start;
        int end;

        public Time ( int start, int end) {
            this.start = start;
            this.end = end;
        }
        public int compareTo(Time other){
            if(this.start - other.start != 0)
                return this.start - other.start;
            else
                return this.end - other.end;
        }

        boolean overLaps(Time newTime) {
            return false;
        }

    }

    private void freeTime(Person[] p, int idx, Time timeCheck, Time result) {

        if(idx == p.length) {
            result = timeCheck;
            return;
        }

        int i = idx;

        List<Time> ptime = p[i].meetingTime;
        int j = 1;
        int startTime = ptime.get(i).start;

        while(true) {

            for (; j < ptime.size() && ptime.get(j).start == startTime; j++) {
                j++;
            }
            int endTime = ptime.get(j).end;

            if (ptime.get(j + 1).start > endTime) {
                Time availableTime = new Time(endTime, ptime.get(j + 1).start);
                if (availableTime.overLaps(timeCheck)) {
                    Time newTime = reducedTime(availableTime, timeCheck);
                    freeTime(p, idx + 1, newTime, result);
                }
                if (idx == 0) {
                    break;
                } else if (timeCheck.start < endTime) {
                    return;
                }
            }
            j = j + 1;
        }
    }

    private Time reducedTime(Time availableTime, Time newTime) {
        return null;
    }
}

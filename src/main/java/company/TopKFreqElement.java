package company;

import java.util.*;

/**
 * Created by avinash on 10/04/2022.
 *
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFreqElement {

    public static void main(String[] args) {

        for(int i : topKFrequent(new int[]{1,1,1,2,2,3}, 2))
            System.out.print(i+ " ");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();

        for(int n: nums) {
            map.put(n, map.getOrDefault(n, 0) +1);
        }

        Comparator<int[]> cmp = (a, b) -> Integer.compare(a[1], b[1]);
        PriorityQueue<int[]> pr = new PriorityQueue(k, cmp);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(pr.size() < k) {
                pr.add(new int[]{entry.getKey(), entry.getValue()});
            } else {
                if(pr.peek()[1] < entry.getValue()) {
                    pr.poll();
                    pr.add(new int[]{entry.getKey(), entry.getValue()});
                }
            }
        }
        int[] res = new int[k];
        int i = 0;
        while(!pr.isEmpty()) {
            res[i] = pr.poll()[0];
            i++;
        }

        return res;
    }
}

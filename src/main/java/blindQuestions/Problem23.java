package blindQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * Do XOR and AND << 1 and loop until AND is 0
 *
 * Merge K Sorted Lists - Leetcode 23
 *
 */


public class Problem23 {

    public static void main(String[] args) {

        ListNode l1_20 = new ListNode(20, null);
        ListNode l1_10 = new ListNode(10,l1_20);
        ListNode l1_1 = new ListNode(1, l1_10);


        ListNode l2_17 = new ListNode(17, null);
        ListNode l2_11 = new ListNode(11,l2_17);
        ListNode l2_3 = new ListNode(3, l2_11);

        ListNode l3_6 = new ListNode(6, null);
        ListNode l3_4 = new ListNode(4,l3_6);
        ListNode l3_2 = new ListNode(2, l3_4);

        ListNode res = mergeSortedList(new ListNode[]{l1_1, l2_3, l3_2});

        while(res != null) {
            System.out.print(res.data + " ");
            res = res.next;
        }
    }


    private static ListNode mergeSortedList(ListNode[] sortedLists) {

        if(sortedLists.length == 0) return null;

        ListNode head = null;

        ListNode temp = null;

        Comparator<ListNode> cmp = (ListNode a, ListNode b) -> {
            return a.data - b.data;
        };

        PriorityQueue<ListNode> pr = new PriorityQueue(cmp);

        for(ListNode list : sortedLists) {
            pr.add(list);
        }

        while(pr.size() > 0) {
            ListNode rem = pr.remove();

            ListNode nextElelment = rem.next;
            if(nextElelment != null) {
                pr.add(nextElelment);
            }

            if(head == null) {
                head = new ListNode(-1, rem);
            } else{
                temp.next = rem;
            }

            temp = rem;
        }
        return head.next;
    }


    private static class ListNode {
        int data;
        ListNode next;

        ListNode(int a, ListNode next) {
            this.data = a;
            this.next = next;
        }


    }
}
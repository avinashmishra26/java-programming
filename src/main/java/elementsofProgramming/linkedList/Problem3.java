package elementsofProgramming.linkedList;

import util.ListNode;
import util.PopulateListData;

/**
 * Created by avinashkumarmishra on 18/09/21.
 * TEST FOR CYCLICITY
 */
public class Problem3 {

    public static void main(String[] args) {
        ListNode<Integer> r = testCyclicity(PopulateListData.populateCycleList());
        System.out.print(r.data);
    }

    static ListNode<Integer> testCyclicity(ListNode<Integer> listNode) {

        ListNode<Integer> p1 = listNode;

        ListNode<Integer> p2 = p1;

        boolean cycleExists = false;

        while (p2.next != null && p2.next.next != null) {
            p2 = p2.next.next;
            if ( p1 == p2) {
                cycleExists = true;
                break;
            }
            p1 = p1.next;
        }

        if (!cycleExists) {
            return null;
        }

        int cycleLength = getCycleLength(p1);

        //Get First Node of Cycle

        //1. traverse cycle length
        ListNode<Integer> traverse = listNode;
        for (int i = 1; i <= cycleLength ; i++) {
            traverse = traverse.next;
        }

        ListNode<Integer> begin = listNode;

        while (traverse != begin) {
            traverse = traverse.next;
            begin = begin.next;
        }

        return begin;
    }

    static int getCycleLength(ListNode<Integer> p) {
        int count = 1;

        ListNode<Integer> next = p.next;

        while ( next != p) {
            next = next.next;
            count++;
        }

        return count;
    }
}

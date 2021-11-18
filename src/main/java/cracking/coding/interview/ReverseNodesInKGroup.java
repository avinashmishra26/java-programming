package cracking.coding.interview;

import util.ListNode;
import util.PopulateListData;
import util.TraverseListData;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

 * k is a positive integer and is less than or equal to the length of the linked list. If the number
 * of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 */
public class ReverseNodesInKGroup {


    public static void main(String[] args) {
        ListNode<Integer> emptyList = null ;
        ListNode l = PopulateListData.populateReverseSubList();
        reverseInGroup(l, 3);

    }

    public static void reverseInGroup(ListNode l, int groupVal) {

        l = reverseLinkedList(l, groupVal);
        TraverseListData.traverse(l);
    }

    private static ListNode reverseLinkedList(ListNode l, int finish) {
        int start = 1;
        int limit = finish;
        boolean lastItr = false;
        if (start == finish) {
            return l;
        }

        ListNode dummyHead = new ListNode(0, null);
        ListNode temp = null;
        ListNode prevGrplastIdx = null;

        while ( l != null) {
            ListNode p = l;
            ListNode q = p.next;
            ListNode lastIdx = null;
            temp = null;

            while (start < finish && q != null) {
                temp = q.next;
                q.next = p;
                start++;
                if (lastIdx == null)
                    lastIdx = p;
                p = q;
                q = temp;
            }

            if (dummyHead.next == null)
                dummyHead.next = p;
            else {
                if (prevGrplastIdx != null)
                    prevGrplastIdx.next = p;
            }
            if ( !lastItr && start < finish){
                lastItr = true;
                l = p;
                finish += limit;
                start++;
                if (lastIdx != null)
                    lastIdx.next = temp;
            } else {
                prevGrplastIdx = lastIdx;
                if (lastIdx != null)
                    lastIdx.next = temp;
                l = temp;
                finish += limit;
                start++;
            }
        }

        return dummyHead.next;
    }

}

package elementsofProgramming.linkedList;

import util.ListNode;
import util.PopulateListData;
import util.TraverseListData;

/**
 * Created by avinashkumarmishra on 17/09/21.
 * Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.
 */
public class Problem1 {

    public static void main(String[] args) {
        ListNode<Integer> emptyList = null ;
        ListNode[] l = PopulateListData.populateMergeTwoSortedList();
        TraverseListData.traverse(mergeTwoSortedList(l[0], l[1]));

        l = PopulateListData.populateMergeTwoSortedList();
        TraverseListData.traverse(mergeTwoSortedList(l[0], null));
    }

    static ListNode<Integer> mergeTwoSortedList(ListNode<Integer> node1, ListNode<Integer> node2) {

        ListNode<Integer> head = new ListNode(), dummyHead;
        dummyHead = head;


        while (node1 != null && node2 != null) {
            if(node1.data <= node2.data) {
                dummyHead.next = node1;
                node1 = node1.next;
            } else {
                dummyHead.next = node2;
                node2 = node2.next;
            }
            dummyHead = dummyHead.next;
        }
        dummyHead.next = node1 != null ? node1 : node2;
        return head.next;

    }
}

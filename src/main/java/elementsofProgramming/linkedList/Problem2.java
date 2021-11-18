package elementsofProgramming.linkedList;

import util.ListNode;
import util.PopulateListData;
import util.TraverseListData;

/**
 * Created by avinashkumarmishra on 18/09/21.
 */
public class Problem2 {

    public static void main(String[] args) {
        TraverseListData.traverse(reverseSubList(PopulateListData.populateReverseSubList(), 2, 9));
    }

    static  ListNode<Integer> reverseSubList(ListNode<Integer> l, int start, int finish) {

        if (start == finish)
            return l;

        ListNode<Integer> dummyHead = new ListNode<>(0, l);
        ListNode<Integer> subListHead = dummyHead;

        int k = 1;
        while (k++ < start)
            subListHead = subListHead.next;


        ListNode<Integer> subListiter = subListHead.next, temp;

        while (k++ < finish) {
            temp = subListiter.next;
            if (temp == null)
                break;
            subListiter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
        }

        return dummyHead.next;
    }
}

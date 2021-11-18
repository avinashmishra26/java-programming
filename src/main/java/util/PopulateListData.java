package util;

/**
 * Created by avinashkumarmishra on 18/09/21.
 */
public class PopulateListData {


    public static ListNode[] populateMergeTwoSortedList() {

        ListNode<Integer> l1 = new ListNode<>(5,null);
        l1.next =  new ListNode<>(10,null);
        l1.next.next =  new ListNode<>(13,null);
        l1.next.next.next =  new ListNode<>(17,null);


        ListNode<Integer> l2 = new ListNode<>(5,null);
        l2.next =  new ListNode<>(12,null);
        l2.next.next =  new ListNode<>(14,null);
        l2.next.next.next =  new ListNode<>(20,null);
        l2.next.next.next.next =  new ListNode<>(25,null);

        return new ListNode[]{l1, l2};
    }

    public static ListNode<Integer> populateReverseSubList() {


        ListNode<Integer> l2 = new ListNode<>(1,null);
        l2.next =  new ListNode<>(2,null);
        l2.next.next =  new ListNode<>(3,null);
        l2.next.next.next =  new ListNode<>(4,null);
        l2.next.next.next.next =  new ListNode<>(5,null);

        return l2;
    }

    public static ListNode<Integer> populateCycleList() {


        ListNode<Integer> l2 = new ListNode<>(1,null);
        l2.next =  new ListNode<>(2,null);
        l2.next.next =  new ListNode<>(3,null);
        l2.next.next.next =  new ListNode<>(4,null);
        l2.next.next.next.next =  new ListNode<>(5,null);
        l2.next.next.next.next.next =  new ListNode<>(6,l2.next.next);


        return l2;
    }

    public static ListNode[] populateOverlappingList() {

        ListNode<Integer> l1 = new ListNode<>(5,null);
        l1.next =  new ListNode<>(10,null);
        l1.next.next =  new ListNode<>(13,null);
        l1.next.next.next =  new ListNode<>(17,null);


        ListNode<Integer> l2 = new ListNode<>(7,null);
        l2.next =  new ListNode<>(12,null);
        l2.next.next =  new ListNode<>(14,null);
        l2.next.next.next =  new ListNode<>(20,null);
        l2.next.next.next.next =  new ListNode<>(25,null);
        l2.next.next.next.next.next = l1.next.next;

        return new ListNode[]{l1, l2};
    }
}

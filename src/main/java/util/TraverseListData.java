package util;

/**
 * Created by avinashkumarmishra on 18/09/21.
 */
public class TraverseListData {

    public static <T> void traverse(ListNode<T> start) {
        while(start !=null) {
            System.out.print(start.data +" -> ");
            start = start.next;
        }
        System.out.println();
    }
}

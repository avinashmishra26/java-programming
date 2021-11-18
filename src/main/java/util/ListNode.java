package util;

/**
 * Created by avinashkumarmishra on 17/09/21.
 */
public class ListNode<T> {

    public T data;
    public ListNode<T>  next;

    public ListNode(){
        data = null;
        next = null;
    }

    public ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }
}

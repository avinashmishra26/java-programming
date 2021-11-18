package elementsofProgramming.linkedList;

/**
 * Created by avinashkumarmishra on 21/10/21.
 *
 */
public class AmazonVolumeRead {

    private static class SingleLinkedList {
        int data;
        SingleLinkedList next;

        SingleLinkedList(int d, SingleLinkedList n) {
            data = d;
            next = n;
        }
    }


    // 1 -> 4 -> 2 -> 3 -> 3 -> 5 (always even no of elements)
    static SingleLinkedList populateList(){
        SingleLinkedList head = new SingleLinkedList(1, null);

        head.next = new SingleLinkedList(4, null);

        head.next.next = new SingleLinkedList(2, null);

        head.next.next.next = new SingleLinkedList(3, null);

        head.next.next.next.next = new SingleLinkedList(3, null);

        head.next.next.next.next.next = new SingleLinkedList(5, null);

        return head;
    }

    public static void main(String[] args) {

        int res = getMaxVolume(populateList());

        System.out.print(res);
    }

    private static int getMaxVolume(SingleLinkedList head) {
        int max = 0;

        while(head != null) {
           max = Math.max(getlastVolume(head) + head.data , max);
           head = head.next;
        }
        return max;
    }

    private static int getlastVolume(SingleLinkedList node) {

        while(node.next.next != null) {
            node = node.next;
        }

        int lastValue = node.next.data;
        node.next = null;
        return lastValue;
    }
}

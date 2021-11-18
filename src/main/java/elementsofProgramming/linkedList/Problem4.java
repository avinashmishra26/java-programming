package elementsofProgramming.linkedList;

import util.ListNode;
import util.PopulateListData;

/**
 * Created by avinashkumarmishra on 25/09/21.
 * TEST FOR OVERLAPPING LISTS—LISTS ARE CYCLE-FREE
 */
public class Problem4 {

    public static void main(String[] args) {
        ListNode[] l = PopulateListData.populateOverlappingList();
        System.out.print(isOverlappingList(l[0], l[1]));
    }

    static boolean isOverlappingList(ListNode<Integer> l1, ListNode<Integer> l2) {
        int l1_len = len(l1), l2_len = len(l2);
        ListNode<Integer> t;

        int len_diff = Math.abs(l1_len - l2_len);

        if (len_diff > 0) {
            if (l1_len > l2_len) {
                while(len_diff-- > 0){
                    l1 = l1.next;
                }
            } else {
                while (len_diff-- > 0) {
                    l2 = l2.next;
                }
            }
        }

        while (l1 != null || l2 != null) {
            if ( l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return false;
    }

    static int len(ListNode<Integer> l1) {
        int cnt = 0;

        while (l1 != null) {
            cnt++;
            l1 = l1.next;
        }
        return cnt;
    }
}

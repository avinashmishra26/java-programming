package cracking.coding.interview.stackQueue;

import java.util.*;

/**
 * Created by avinashkumarmishra on 19/10/21.
 * 2022
 */
public class PrevGreaterElement {

    public static void main(String[] args) {

        int[] n = {6,8,4,3,5,7,1,2};
        //initial
        System.out.println("initial");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

        prevGreaterElement(n);
        System.out.println("\nResult");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

    }

    //Using Idx,so backward traversal
    private static void prevGreaterElement(int[] arr) {

        Deque<Integer> deque = new LinkedList<>();

        for(int i = arr.length-1; i >= 0; i--) {

            while(!deque.isEmpty() && arr[deque.peekFirst()] < arr[i]) {
                arr[deque.removeFirst()] = arr[i];
            }

            deque.addFirst(i);
        }

        while(deque.isEmpty() == false) {
            arr[deque.removeFirst()] = -1;

        }
    }
}

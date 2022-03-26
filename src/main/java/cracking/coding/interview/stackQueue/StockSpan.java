package cracking.coding.interview.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 03/11/21.
 * 2022
 *
 * PrevGreaterElement using idx method
 */

public class StockSpan {



    public static void main(String[] args) {

        int[] n = {6, 8, 4, 3, 5, 7, 1, 2};

        prevGreaterElementVariant(n);
        System.out.println("\nResult");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }

    }

    //Using Idx,so backward traversal
    private static void prevGreaterElementVariant(int[] arr) {

        Deque<Integer> deque = new LinkedList<>();

        for(int i = arr.length-1; i >= 0; i--) {

            while(!deque.isEmpty() && arr[deque.peekFirst()] < arr[i]) {
                int idx = deque.removeFirst();
                arr[idx] = Math.abs(i-idx);
            }

            deque.addFirst(i);
        }

        while(deque.isEmpty() == false) {
            int idx = deque.removeFirst();
            arr[idx] = idx+1;

        }
    }
}
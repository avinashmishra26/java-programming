package cracking.coding.interview.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 19/10/21.
 * Next Greater Element
 * Input : {10,9,5,7,6}          and   {1,5,2,3,6}
 * output : {-1, -1, 7, -1, -1}  and   {5, 6, 3, 6, -1}
 *
 * 2022
 *
 */


public class NextGreaterElement {

    public static void main(String[] args) {

        int[] n1 = {1,5,2,3,6};
        intialDisplay(n1);
        backwardMove(n1);


        int[] n2 = {1,5,2,3,6};
        intialDisplay(n2);
        forwardMove(n2);

    }

    static void intialDisplay(int[] n) {
        //initial
        System.out.println("\ninitial");
        for(int i = 0; i < n.length ; i++) {
            System.out.print(n[i]+ " ");
        }
    }

    static void forwardMove(int[] n) {
        System.out.println("\nforwardMove");


        Deque<Integer> deque = new LinkedList<>();


        for(int i = 0; i < n.length ; i++) {

            while(!deque.isEmpty() && n[deque.peekFirst()] < n[i] ){
                n[deque.removeFirst()] = n[i];
            }

            deque.addFirst(i);
        }

        while(!deque.isEmpty()){
            int idx = deque.removeFirst();
            n[idx] = -1;
        }

        //Result
        System.out.println("\nResult");
        for(int i = 0; i < n.length ; i++) {
            System.out.print(n[i]+ " ");
        }
    }


    static void backwardMove(int[] n) {
        System.out.print("\nbackwardMove ::");

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(n[n.length-1]);

        n[n.length-1] = -1;

        for(int i = n.length-2; i >=0 ; i--) {

            int ele = n[i];

            while(!deque.isEmpty() && deque.peekFirst() < ele){
                deque.removeFirst();
            }

            int res = deque.peekFirst() != null ? deque.peekFirst() : -1;
            deque.addFirst(ele);
            n[i] = res;

        }

        //Result
        System.out.print("Result : ");
        for(int i = 0; i < n.length ; i++) {
            System.out.print(n[i]+ " ");
        }
    }
}

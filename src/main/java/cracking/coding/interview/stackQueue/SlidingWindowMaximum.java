package cracking.coding.interview.stackQueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 11/11/21.
 *
 * 2022
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int[] res = subArrayMax(new int[]{2,9,3,8,7,12,4,6}, 4);

        for(int r : res) {
            System.out.print(r + " ");
        }


        System.out.println();
        res = subArrayMaxSecondMethod(new int[]{2,9,3,8,7,12,4,6}, 4);

        for(int r : res) {
            System.out.print(r + " ");
        }
    }

    //using greater element concept
    private static int[] subArrayMax(int[] arr, int windowSize) {

        int[] nge = new int[arr.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(0);

        for(int i = 1; i < arr.length; i++) {

            while(!deque.isEmpty() && arr[deque.peekFirst()] < arr[i]) {
                int idx = deque.removeFirst();
                nge[idx] = i;
            }

            deque.addFirst(i);
        }

        while(!deque.isEmpty()){
            int idx = deque.removeFirst();
            nge[idx] = arr.length;
        }

        int[] res = new int[arr.length - windowSize+1];

        for(int i = 0; i <= arr.length - windowSize; i++) {

            int j = i;

            while(nge[j] < i+windowSize) {
                j = nge[j];
            }
            res[i] = arr[j];
        }

        return res;
    }


    //using queue in just one iteration
    private static int[] subArrayMaxSecondMethod(int[] arr, int windowSize) {

        Deque<Integer> deque = new LinkedList<>();

        int[] res = new int[arr.length - windowSize+1];

        int i;
        for( i = 0; i < windowSize; i++) {

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }

           deque.addLast(i);
        }

        res[0] = arr[deque.peekFirst()];

        for(; i < arr.length; i++) {

            while (!deque.isEmpty() && deque.peekFirst() <= i-windowSize) {
                deque.removeFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.removeLast();
            }

            deque.addLast(i);

            res[i-windowSize+1] = arr[deque.peekFirst()];
        }
        return res;
    }
}

package elementsofProgramming.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 20/10/21.
 * Optimized method to calculate difference of Max-Min of all possible sub arrays.
 * Same method can be used to calculate sum of Max-Min of all possible sub arrays.
 */
public class OptimizedSubArrayCalculation {

    public static void main(String[] args) {

        //int[] n = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};

        int[] n = {3,1,2,4 };


        /*long start = System.currentTimeMillis();
        System.out.println("start ");
        int sum = 0;
        for(int partition = 2; partition <= n.length; partition++)
            sum += SumOfKsubArray(n, partition);
        System.out.println(sum);
        System.out.println("finish " + (System.currentTimeMillis()-start));*/


        //best performant
        long start1 = System.currentTimeMillis();
        System.out.println("start ");
        System.out.println(differenceMaxMin(n));
        System.out.println("finish " + (System.currentTimeMillis()-start1));

    }



    static int differenceMaxMin(int[] n) {

        int diff = 0;

        int[] nge = Arrays.copyOf(n, n.length);
        int[] sme = Arrays.copyOf(n, n.length);

        Deque<Integer> greater = new LinkedList<>();
        Deque<Integer> smaller = new LinkedList<>();

        //Find next greater
        greater.addFirst(0);

        //Find next smaller
        smaller.addFirst(0);

        for(int i = 1; i < n.length; i++) {
            int ele = n[i];
            int ele1 = n[i];

            while (!greater.isEmpty() && nge[greater.peekFirst()] < ele) {
                nge[greater.removeFirst()] = i;
            }

            while (!smaller.isEmpty() && sme[smaller.peekFirst()] > ele1) {
                sme[smaller.removeFirst()] = i;
            }

            greater.addFirst(i);
            smaller.addFirst(i);

        }

        while (!greater.isEmpty()){
            nge[greater.removeFirst()] = nge.length;
        }

        while (!smaller.isEmpty()){
            sme[smaller.removeFirst()] = sme.length;
        }

        int max =0, min = 0;
        int j = 0;
        for (int partition = 2; partition <= n.length; partition++) {
            for (int i = 0; i <= n.length - partition; i++) {

               j = i;

                while (nge[j] < (i + partition)) {
                    j = nge[j];
                }

                max = n[j];


                j = i;


                while (sme[j] < (i + partition)) {
                    j = sme[j];
                }

                min = n[j];

                diff += Math.abs(max - min);
            }
        }
        return diff;
    }

    public static int SumOfKsubArray(int arr[] , int k)
    {
        int sum = 0;  // Initialize result

        // The queue will store indexes of useful elements
        // in every window
        // In deque 'G' we maintain decreasing order of
        // values from front to rear
        // In deque 'S' we  maintain increasing order of
        // values from front to rear
        Deque<Integer> S=new LinkedList<>(),G=new LinkedList<>();

        // Process first window of size K
        int i = 0;
        for (i = 0; i < k; i++)
        {
            // Remove all previous greater elements
            // that are useless.
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // Remove all previous smaller that are elements
            // are useless.
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        // Process rest of the Array elements
        for (  ; i < arr.length; i++ )
        {
            // Element at the front of the deque 'G' & 'S'
            // is the largest and smallest
            // element of previous window respectively
            sum += Math.abs(arr[S.peekFirst()] - arr[G.peekFirst()]);

            // Remove all elements which are out of this
            // window
            while ( !S.isEmpty() && S.peekFirst() <= i - k)
                S.removeFirst();
            while ( !G.isEmpty() && G.peekFirst() <= i - k)
                G.removeFirst();

            // remove all previous greater element that are
            // useless
            while ( !S.isEmpty() && arr[S.peekLast()] >= arr[i])
                S.removeLast(); // Remove from rear

            // remove all previous smaller that are elements
            // are useless
            while ( !G.isEmpty() && arr[G.peekLast()] <= arr[i])
                G.removeLast(); // Remove from rear

            // Add current element at rear of both deque
            G.addLast(i);
            S.addLast(i);
        }

        // Sum of minimum and maximum element of last window
        sum += Math.abs(arr[S.peekFirst()] - arr[G.peekFirst()]);

        return sum;
    }
}

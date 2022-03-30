package cracking.coding.interview.stackQueue;

/**
 * Created by avinashkumarmishra on 28/03/22.
 *
 *  LargestAreaHistogram
 *
 **/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class LargestAreaHistogram {


    public static void main(String[] args) {
        System.out.println(getLargestHistogram(new int[]{6,2,5,4,5,1,6}));



        System.out.println(getMaxHistogram(new int[]{6,2,5,4,5,1,6}));

    }


    private static int getLargestHistogram(int[] arr) {

        Deque<Integer> ps = new LinkedList<>();
        int[] psa = new int[arr.length];

        Deque<Integer> ns = new LinkedList<>();
        int[] nsa = new int[arr.length];

        Arrays.fill(nsa, arr.length);

        for(int i = 0; i < arr.length; i++) {


            while(!ps.isEmpty() && arr[ps.peekFirst()] > arr[i] ) {
                ps.removeFirst();
            }

            psa[i] = ps.isEmpty() ? -1 : ps.peekFirst();
            ps.addFirst(i);



            while(!ns.isEmpty() && arr[ns.peekFirst()] > arr[i] ) {
                nsa[ns.removeFirst()] = i;
            }

            ns.addFirst(i);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            int t = arr[i] * (nsa[i] - psa[i]-1);

            max = Math.max(t, max);
        }
        return max;

    }


    //method 2 : having complexity = n^2
    private static  int getMaxHistogram(int[] arr) {

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {

            int ele = arr[i];
            int leftMin = -1;
            int rightMin = arr.length;

            for(int j = i-1; j >=0 ; j--) {
                if(ele > arr[j]) {
                    leftMin = j;
                    break;
                }
            }

            for(int k = i+1; k < arr.length; k++) {
                if(ele > arr[k]) {
                    rightMin = k;
                    break;
                }
            }
            max = Math.max(max, arr[i]*(rightMin-leftMin-1));

        }
        return max;

    }
}
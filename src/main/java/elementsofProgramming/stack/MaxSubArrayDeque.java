package elementsofProgramming.stack;

import java.util.*;

/**
 * Created by avinashkumarmishra on 26/10/21.
 */
public class MaxSubArrayDeque {



    public static void main(String[] args) {
        int[] n = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};

        //optimzed way o(n) with 0(n) space complexity
        System.out.println(getMaxSubArrayDequeBest(n, 4));

        //worst method ( n2)
        getmaxSubArrayDeque(n, 4).forEach(e -> System.out.print(e +" "));
    }


    static int getMaxSubArrayDequeBest(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < k; i++) {

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.add(i);
        }



        for(int i = k; i < nums.length; i++) {

            max = Math.max(max,  nums[deque.peekFirst()]);

            while(!deque.isEmpty() && deque.peekFirst() <= i - k ){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.add(i);
        }

        max = Math.max(max,  nums[deque.peekFirst()]);

        return max;
    }

    static List<Integer> getmaxSubArrayDeque(int[] nums, int k) {
        List<Integer> listOfMax = new ArrayList<>();

        //int max = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length - k; ) {
            int j = i;
            Deque<Integer> deque = new LinkedList();
            while (j < i + k){
                if(deque.isEmpty()){
                    deque.addFirst(j);
                    j++;
                }
                while (nums[deque.peekFirst()] > nums[j] && j < i + k) {
                    deque.addFirst(j);
                    j++;
                }

                while (!deque.isEmpty() && nums[deque.peekFirst()] < nums[j] && j < i + k) {
                    deque.removeFirst();
                }
            }

            listOfMax.add(nums[deque.peekLast()]);
            i++;
            while (!deque.isEmpty() && deque.peekLast()  < i) {
                deque.removeLast();
            }
        }

        return listOfMax;
    }

}

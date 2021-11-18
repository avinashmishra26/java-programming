package elementsofProgramming.greedy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 07/11/21.
 * Compute the largest rectangle under the skyline
 */
public class Problem8 {

    public static void main(String[] args) {
        System.out.print(getLargestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    //T(n) = O(n)
    public static int getLargestRectangleArea(int[] heights) {

        int[] prevSmall = new int[heights.length];
        int[] nextSmall = new int[heights.length];

        //For nextSmall
        Deque<Integer> idx = new LinkedList<>();
        idx.addFirst(0);

        for(int i = 1; i <heights.length; i++) {
            int e = heights[i];

            while(!idx.isEmpty() && heights[idx.peekFirst()] > e){
                nextSmall[idx.removeFirst()] = i;
            }

            idx.addFirst(i);
        }

        while(!idx.isEmpty()){
            nextSmall[idx.removeFirst()] = heights.length;
        }


        //For prevSmall
        idx = new LinkedList<>();
        idx.addFirst(heights.length-1);

        for(int i = heights.length-1; i >= 0; i--) {
            int e = heights[i];

            while(!idx.isEmpty() && heights[idx.peekFirst()] > e){
                prevSmall[idx.removeFirst()] = i;
            }

            idx.addFirst(i);
        }
        while(!idx.isEmpty()){
            prevSmall[idx.removeFirst()] = -1;
        }

        int maxRectangle = 0;

        for(int i = 0; i <heights.length; i++) {
            int width = nextSmall[i] - prevSmall[i];
            int area = (width-1) * heights[i];

            maxRectangle = Math.max(maxRectangle,area );

        }

        return maxRectangle;
    }
}

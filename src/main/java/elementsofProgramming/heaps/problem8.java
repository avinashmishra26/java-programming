package elementsofProgramming.heaps;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 28/10/21.
 */
public class problem8 {

    public static void main(String[] args) {
        int[] a = { 2,1,5,6,2,3 } ;
        System.out.print(largestRectangleArea(a));
    }

    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        int[] rightIdx = new int[heights.length];

        nextSmaller(heights, rightIdx);


        int[] leftIdx = new int[heights.length];

        prevSmaller(heights, leftIdx);

        for( int i = 0; i < heights.length; i++) {
            int width = rightIdx[i] - leftIdx[i] - 1;
            maxArea = Math.max(maxArea, width*heights[i]);
        }

        return maxArea;
    }

    static void prevSmaller(int[] heights, int[] leftIdx) {
        Deque<Integer> smallerleft = new LinkedList<>();

        leftIdx[0] = -1;
        smallerleft.addFirst(0);

        for(int i = 1; i < heights.length; i++) {
            int ele = heights[i];

            while(!smallerleft.isEmpty() && heights[smallerleft.peekFirst()] > ele ){
                smallerleft.removeFirst();
            }

            leftIdx[i] = smallerleft.isEmpty() ? -1: smallerleft.peekFirst() ;

            smallerleft.addFirst(i);
        }

    }

    static void nextSmaller(int[] heights, int[] rightIdx) {
        Deque<Integer> smallerRight = new LinkedList();

        for(int i = 0; i < heights.length; i++) {
            int ele = heights[i];

            while(!smallerRight.isEmpty() && heights[smallerRight.peekFirst()] > ele ){
                rightIdx[smallerRight.removeFirst()] = i;
            }

            smallerRight.addFirst(i);
        }
        while(!smallerRight.isEmpty()){
            rightIdx[smallerRight.removeFirst()] = heights.length;
        }
    }
}

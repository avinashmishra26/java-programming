package cracking.coding.interview.backtracking.basic;

/* Created by avinashkumarmishra on 22/03/22.
*  2022
*/

public class MaxArray {

    public static void main(String[] args) {
        System.out.print(maxOfArray(new int[]{22,33,4,19,7},0));
    }

    public static int maxOfArray(int[] arr, int idx) {
        if(arr.length == idx){
            return Integer.MIN_VALUE;
        }
        return Math.max(arr[idx], maxOfArray(arr, idx+1));

    }
}
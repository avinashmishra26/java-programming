package cracking.coding.interview.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 13/10/21.
 *
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

     "123"
     "132"
     "213"
     "231"
     "312"
     "321"
     Given n and k, return the kth permutation sequence.
 */
public class Permutation {

    public static void main(String[] args) {
        permute(4,new int[]{1,2}).stream().forEach(e -> System.out.print(e +" -- "));

        System.out.println();
        System.out.print(permute(4,new int[]{1,2}).stream().count());;
    }

    public static List<List<Integer>> permute(int box, int[] nums) {
        //int[] boxes = new int[nums.length];
        List<List<Integer>> paths = new ArrayList<>();

        getPermutation(new int[box], nums , 0 , paths) ;

        return paths;
    }

    public static void getPermutation(int[] boxes , int[] nums, int itemIdx, List<List<Integer>> paths) {

        if ( itemIdx == nums.length) {
            List<Integer> res = new ArrayList<>();
            for(int i = 0 ; i< boxes.length; i++) {
                res.add(boxes[i]);
            }
            paths.add(res);
            return;
        }


        for ( int i = 0 ; i<boxes.length ; i++) {
            if(boxes[i] == 0) {
                boxes[i] = nums[itemIdx];
                getPermutation(boxes, nums, itemIdx+1, paths);
                boxes[i] = 0;
            }
        }

    }

}

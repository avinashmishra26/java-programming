package blindQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 10/10/21.
 *
 * Combination Sum - Backtracking - Leetcode 39
 *
 */


public class Problem20 {

    public static void main(String[] args) {

        ;
        System.out.print(combinationSum(new int[]{1,2}, 4));

    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result =  new ArrayList();

        combinationSum(candidates, 0, target, new ArrayList(), result);

        return result;
    }

    public static void combinationSum(int[] candidates, int idx, int target, List<Integer> temp,  List<List<Integer>> result ) {

        if(idx == candidates.length || target < 0) return;

        if(target == 0) {
            result.add(temp);
            return;
        }

        ArrayList included = new ArrayList(temp);
        included.add(candidates[idx]);

        ArrayList excluded = new ArrayList(temp);

        combinationSum(candidates, idx, target-candidates[idx], included, result);

        combinationSum(candidates, idx+1, target,excluded, result);
    }

}
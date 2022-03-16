package cracking.coding.interview.backtracking;

import java.util.*;

/**
 * Created by avinashkumarmishra on 06/11/21.
 * 2022
 */
public class ClimbStairs {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();

        climbStairsPath(5, new int[]{1,2}, "", res);

        res.forEach(e -> System.out.println(e));

    }

    private static void climbStairsPath(int stair, int[] options, String start, List<String> res) {

        if(stair == 0) {
            res.add(start);
            return;
        } else if(stair < 0) {
            return;
        }


        for(int option : options) {
            climbStairsPath(stair-option, options, start+"->"+option, res);
        }
    }
}

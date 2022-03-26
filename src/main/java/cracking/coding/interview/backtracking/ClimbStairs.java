package cracking.coding.interview.backtracking;

import java.util.*;

/**
 * Created by avinashkumarmishra on 06/11/21.
 * 2022
 */
public class ClimbStairs {

    public static void main(String[] args) {
        List<String> res = new ArrayList<>();

        climbStairsPath(4, new int[]{1,2,3}, "", res);

        System.out.print("[");
        res.forEach(e -> System.out.print(e + ", "));
        System.out.println("]");

        System.out.println("New method");

        System.out.println(getClimbStairsPath(4));

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

    private static ArrayList<String> getClimbStairsPath(int n) {
        if(n == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        } else if(n < 0) {
            return new ArrayList<>();
        }
        ArrayList<String> res = new ArrayList<>();

        for(String s : getClimbStairsPath(n-1))
            res.add("->1"+s);

        for(String s : getClimbStairsPath(n-2))
            res.add("->2"+s);

        for(String s : getClimbStairsPath(n-3))
            res.add("->3"+s);

        return res;
    }
}

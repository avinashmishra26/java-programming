package elementsofProgramming.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by avinashkumarmishra on 11/10/21.
 * 2022
 */
public class ClimbStairs {

    public static void main(String[] args) {

        List<String> path = new ArrayList<>();
        //Map<Integer, List<Integer>> paths = new HashMap<>();
        //paths.put(0, l);
        int totalStairs = 5, jumps = 3;
        climbStairs(totalStairs, jumps, "", path);
        System.out.println(path);
    }

    public static void climbStairs(int totalStairs, int jumps, String start, List<String> path) {

        if (totalStairs == 0) {
            path.add(start);
        } else if (totalStairs < 0) {
            return;
        }
        System.out.println("For Stairs " +totalStairs);

        for (int i = 1; i <= jumps; i++) {
            if ((totalStairs - i) >= 0 ) {
                climbStairs(totalStairs-i, jumps, start.concat(i+""), path);
            }
        }
    }
}

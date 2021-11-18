package cracking.coding.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 13/10/21.
 * Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 */
public class Combinations {

    public static void main(String[] args) {
        combine(4,2).stream().forEach(e -> System.out.print(e +" -- "));
        System.out.println();
        System.out.print(combine(3,2).stream().count());;
    }

    public static List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> paths = new ArrayList<>();

        getCombination(n, k, new ArrayList<>(), 1, paths);

        return paths;
    }

    private static void getCombination(int n, int k, List<Integer> start, int boxSelection, List<List<Integer>> paths) {
        if (k == 0){
            paths.add(start);
            return;
        } else if ( n == 0) {
            return;
        }

        List<Integer> next = new ArrayList<>(start);
        next.add(boxSelection);

        int nextboxSelection = boxSelection+1;

        getCombination(n-1, k-1, next, nextboxSelection, paths);
        getCombination(n-1, k, start, nextboxSelection, paths);
    }

}

package elementsofProgramming.greedy;

import java.util.*;

/**
 * Created by avinashkumarmishra on 05/10/21.
 * The 3-sum problem
 */
public class Problem4 {

    public static void main(String[] args) {

        List r = Arrays.asList(11,2,5,7,3);


       //getThreeSumProblemOptimized(r, 21).forEach(e -> System.out.print(e));

        System.out.println();

        List<int[]> res = getThreeSumProblemN2(r, 21);

        //List<int[]> res = getThreeSumProblem(r, 21);


        for(int[] a : res){
            System.out.println(a[0] + " " + a[1] + " "+ a[2]);
        }
    }

    public static List<Integer> getThreeSumProblemOptimized(List<Integer> arr, int sum) {

        Collections.sort(arr);

        for(int i = 0, j = arr.size() - 1 ; ;) {

        }
    }


    //Better Brute- Force O(n^2) + O(n) as space complexity
    public static List<int[]> getThreeSumProblemN2(List<Integer> arr, int sum) {

        final Set<Integer> map = new HashSet<>();

        for (int a : arr) {
            map.add(a);
        }

        List<int[]> res = new ArrayList<>();

        for ( int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                int remain = sum - arr.get(i) - arr.get(j);
                if(map.contains(remain)) {
                    res.add(new int[]{arr.get(i), arr.get(j) ,remain});
                }

            }
        }
        return res;
    }

    //Brute- Force O(n^3) : remove the duplicate values
    public static List<int[]> getThreeSumProblem(List<Integer> arr, int sum) {
        List<int[]> res = new ArrayList<>();

        for ( int i = 0; i < arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
                    for ( int k = 0; k < arr.size(); k++) {
                            if (arr.get(i) + arr.get(j) + arr.get(k) == sum )
                                res.add(new int[]{arr.get(i), arr.get(j) ,arr.get(k)});
                    }
                }
            }
        return res;
    }
}

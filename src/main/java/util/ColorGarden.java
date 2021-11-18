package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 31/10/21.
 */
public class ColorGarden {

    public static void main(String[] args)
    {
        int[] res = gardenNoAdj(3, new int[][] {{1,2},{2,3},{3,1}});
        for( int r : res)
            System.out.print(r);

    }

    static public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> graph = new ArrayList<>(n);
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0] - 1).add(path[1] - 1);
            graph.get(path[1] - 1).add(path[0] - 1);
        }

        for (int i = 0; i < n; i++) {
            int mask = 0;
            // There are no more than 3 paths
            // use first 4 bits of integer to represent mask, such as 1110, then we choose color 1 which is first bit position
            for (int neighbor : graph.get(i)) {
                mask = mask | (1 << ans[neighbor]);
            }
            // if a bit position is not used, then we choose that bit
            for (int c = 1; c <= 4 && ans[i] == 0; c++) {
                if ((mask & (1 << c)) == 0) {
                    ans[i] = c;
                }
            }
        }

        return ans;
    }
}

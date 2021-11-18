package cracking.coding.interview.graph;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 01/11/21.
 */
public class CountIsland {


    public static void main(String[] args)throws IOException {

        int[][] arr= { {0, 0, 1,1}, {0, 0, 1, 0}, {0, 1, 1, 0}, {1,1,1,0}, {1,1,0,0} };

        boolean[][] visited = new boolean[arr.length][arr[0].length];

        List<List<Coordinate>> islands = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                if(visited[i][j] == false && arr[i][j] == 0) {
                    List<Coordinate> island = new ArrayList<>();
                    getIsland(arr, i, j, visited, island);
                    islands.add(island);
                }

            }
        }

        islands.forEach(e -> System.out.println(e));
    }

    private static class Coordinate {
        int i;
        int j;

        Coordinate(int i, int j){
            this.i = i;
            this.j = j;
        }

        @Override
        public String toString() {
            return "Coordinate{" +
                    "i=" + i +
                    ", j=" + j +
                    '}';
        }
    }

    private static void getIsland(int[][] grid, int i, int j, boolean[][] visited, List<Coordinate> pair) {


        int[][] shifts = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };

        visited[i][j] = true;
        pair.add(new Coordinate(i, j));

        for(int[] s : shifts) {
            int next_i = i + s[0];
            int next_j = j + s[1];

            if(isFeasible(grid, next_i , next_j) &&  visited[next_i][next_j] == false && grid[next_i][next_j] == 0) {
                getIsland(grid, next_i, next_j, visited, pair);
            }
        }
    }

    private static boolean isFeasible(int[][] grid, int i, int j) {
        return i >= 0 && j>= 0 && i < grid.length && j < grid[i].length;
    }
}

package util;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 29/10/21.
 */
public class RottingOranges {

    public static void main(String[] args) {
        System.out.print(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    public static int orangesRotting(int[][] grid) {

        Deque<Pair> rottenIdx = new LinkedList<>();
        int nonRottenCounter = 0;
        int time = -1;

        for(int i = 0 ; i < grid.length; i++) {
            for(int j = 0 ; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    rottenIdx.add(new Pair(i, j));
                } else if(grid[i][j] == 1) {
                    nonRottenCounter++;
                }
            }
        }

        if(nonRottenCounter == 0) {
            return 0;
        }
        while(!rottenIdx.isEmpty()) {

            int items = rottenIdx.size();
            for(int i = 1; i<= items; i++) {
                Pair temp = rottenIdx.remove();
                int[][] shifts = { {0,1}, {0,-1}, {1,0}, {-1,0} };
                for(int[] s : shifts) {
                    int next_i = temp.i + s[0];
                    int next_j = temp.j + s[1];
                    if(isFeasible(grid, next_i, next_j)) {
                        rottenIdx.add(new Pair(next_i, next_j));
                        grid[next_i][next_j] = 2;
                        nonRottenCounter--;
                    }
                }

            }
            time++;
        }

        return  nonRottenCounter == 0 ? time : -1;

    }

    private static class Pair {
        int i;
        int j;

        Pair(int i , int j) {
            this.i = i;
            this.j = j;
        }

    }

    private static boolean isFeasible(int[][] grid, int i, int j) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}

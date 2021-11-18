package cracking.coding.interview.graph;

/**
 * Created by avinashkumarmishra on 02/11/21.
 * Given a 2D grid consists of 0s (land) and 1s (water).  An island is a maximal 4-directionally
 * connected group of 0s and a closed island is an island totally (all left, top, right, bottom) surrounded by 1s.

 * Return the number of closed islands.
 *
 * https://leetcode.com/problems/number-of-closed-islands/
 */
public class ClosedIsland {

    public int closedIsland(int[][] grid) {

        if(grid == null) return 0;

        int cnt = 0;

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for( int i = 0; i < grid.length; i++) {
            for( int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0 && !visited[i][j]) {

                    boolean[] test = new boolean[1];
                    testClosed(grid, i , j, visited, test);
                    if(!test[0])
                        cnt += 1;

                }
            }
        }
        return cnt;
    }

    private void testClosed(int[][] grid, int i , int j, boolean[][] visited, boolean[] test) {

        if( i == 0 || j == 0 || i == grid.length-1 || j == grid[0].length-1) {
            test[0] = true;
            return;
        }

        visited[i][j] = true;

        int[][] shifts = { {0,1}, {0,-1}, {1,0}, {-1,0} };

        for(int[] s: shifts) {
            int next_i = i + s[0];
            int next_j = j + s[1];

            if(grid[next_i][next_j] == 0 && !visited[next_i][next_j]) {
                testClosed(grid, next_i , next_j, visited, test);
            }
        }
    }
}

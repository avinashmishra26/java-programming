package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 23/10/21.
 *
 * Collect the Gold of not-connectd island and return the max gold on any island
 */
public class GoldMineIsland {

    public static void main(String[] args) {
        int[][] grid = { {10,0,1,20,0,8,0}, {20,0,0,0,0,6,0}, {30,0,0,9,12,3,4}, {40,0,2,5,8,3,11}, {0,0,0,0,0,9,0}, {5,6,7,0,7,4,2},{8,9,10,0,1,10,8} };
        System.out.print(getMaximumGold(grid));
    }

    public static int getMaximumGold(int[][] grid) {
        int max = Integer.MIN_VALUE, sum = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0;i < grid.length; i++) {
            for(int j=0; j < grid[0].length; j++) {
                if(grid[i][j] != 0 && !visited[i][j]) {
                    sum = travelAndCollectGold(grid, i , j, visited);
                    max = Math.max(sum, max);
                }
            }
        }
        return max;
    }

    private static int travelAndCollectGold(int[][] grid, int i, int j, boolean[][] visited) {
       if ( i< 0 || j < 0 || i >= grid.length || j>= grid[0].length) {
            return 0;
        }

        int sum = 0;
        if (!visited[i][j] && grid[i][j] != 0) {
            visited[i][j] = true;
            int[][] shifts = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] s : shifts) {
                sum += travelAndCollectGold(grid, i + s[0], j + s[1], visited);
            }
            sum += grid[i][j];
        }
        return sum;
    }
}

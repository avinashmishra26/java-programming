package cracking.coding.interview.backtracking;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 12/10/21.
 * https://leetcode.com/problems/path-with-maximum-gold/
 *
 * In a gold mine grid of size m x n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

 Return the maximum amount of gold you can collect under the conditions:

 Every time you are located in a cell you will collect all the gold in that cell.
 From your position, you can walk one step to the left, right, up, or down.
 You can't visit the same cell more than once.
 Never visit a cell with 0 gold.
 You can start and stop collecting gold from any position in the grid that has some gold.

 */
public class MaximumGold {

    public static void main(String[] args) {

        //int[][] a = {{1,0,7},{2,0,6},{3,4,5},{0,3,0},{9,0,20}};

        int[][] a = {{0,6,0},{5,8,7},{0,9,0}};

        System.out.print(getMaximumGold(a));
    }

    public static int getMaximumGold(int[][] grid) {
        int[] max = new int[1];

        for(int i=0 ; i < grid.length; i++) {
            for(int j=0 ; j < grid[i].length; j++) {

                getMaxGold(grid, i, j, max);
            }
        }

        return max[0];
    }

    private static int getMaxGold (int[][] grid,int row, int col, int[] max) {
        if (!(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length)) {
            return 0;
        } else if (grid[row][col] == 0 || grid[row][col] == -1){
            return 0;
        }
        int val = 0;
        int[][] shifts = {{0,1},{0,-1},{1,0},{-1,0}};
        int temp = grid[row][col];
        grid[row][col] = -1;
        for (int[] s : shifts) {
            val = Math.max(val, getMaxGold(grid, row+s[0], col+s[1], max));
        }
        val = temp + val;
        if ( val > max[0]) {
            max[0] = val;
        }
        grid[row][col] = temp;
        return val;
    }
}

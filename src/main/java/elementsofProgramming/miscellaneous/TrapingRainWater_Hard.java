package elementsofProgramming.miscellaneous;

import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Created by avinashkumarmishra on 28/10/21.
 * Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.
 * https://leetcode.com/problems/trapping-rain-water-ii/
 */
public class TrapingRainWater_Hard {

    public static void main(String[] args) {
        int[][] a = { {1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}} ;
        System.out.print(trapRainWater(a));
    }

    private static int getRainWater2D(int[][] heightMap, boolean[][] visited, PriorityQueue<Block> pq) {
        int totalWater = 0;

        while (!pq.isEmpty()) {
            Block b = pq.poll();
            int indx_i = b.i;
            int indx_j = b.j;


            int[][] shifts = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] s : shifts) {
                int next_i = indx_i + s[0];
                int next_j = indx_j + s[1];
                if (next_i >= 0 && next_j >= 0 && next_i < heightMap.length && next_j < heightMap[0].length && !visited[next_i][next_j]) {
                    int preHeight = heightMap[indx_i][indx_j];
                    int newHeight = heightMap[next_i][next_j];

                    if (preHeight > newHeight) {
                        totalWater += (preHeight - newHeight);
                        newHeight = preHeight;
                    }
                    heightMap[next_i][next_j] = newHeight;
                    pq.add(new Block(next_i, next_j, newHeight));
                    visited[next_i][next_j] = true;
                    //break;
                }
            }
        }
        return totalWater;
    }

    public static int trapRainWater(int[][] heightMap) {
        int maxWater = 0;

        boolean[][] visited = new boolean[heightMap.length][heightMap[0].length];
        PriorityQueue<Block> pq = new PriorityQueue();

        for(int i = 0; i < heightMap[0].length; i++){
            pq.add(new Block(0, i, heightMap[0][i]));
            visited[0][i] = true;
        }
        int lastRow = heightMap.length-1;
        for(int i = 0; i < heightMap[0].length; i++){
            pq.add(new Block(lastRow, i, heightMap[lastRow][i]));
            visited[lastRow][i] = true;
        }


        for(int i = 0; i < heightMap.length; i++){
            if (!visited[i][0]) {
                pq.add(new Block(i, 0, heightMap[i][0]));
                visited[i][0] = true;
            }
        }
        int lastCol = heightMap[0].length-1;
        for(int i = 0; i < heightMap.length; i++){
            if (!visited[i][lastCol]) {
                pq.add(new Block(i, lastCol, heightMap[i][lastCol]));
                visited[i][lastCol] = true;
            }
        }

        return getRainWater2D(heightMap, visited, pq);
    }

    private static class Block implements Comparable<Block> {
        int i;
        int j;
        int idx;

        public Block( int i, int j, int idx) {
            this.i = i;
            this.j = j;
            this.idx = idx;
        }

        public int compareTo(Block block) {
            return this.idx - block.idx;
        }
    }
}

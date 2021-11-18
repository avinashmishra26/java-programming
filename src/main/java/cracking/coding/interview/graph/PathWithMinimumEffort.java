package cracking.coding.interview.graph;

import java.util.PriorityQueue;

/**
 * Created by avinashkumarmishra on 14/11/21.
 *
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * Use PriorityQueue
 */
public class PathWithMinimumEffort {

    static int[] res = new int[1];

    public static void main(String[] args) {
        int[][] arr = {{4, 3, 4, 10, 5, 5, 9, 2},{10, 8, 2, 10, 9, 7, 5, 6},{5, 8, 10, 10, 10, 7, 4, 2},{5, 1, 3, 1, 1, 3, 1, 9},{6, 4, 10, 6, 10, 9, 4, 6}};

        //Use PriorityQueue
        System.out.print(bestMinimumEffortPath1(arr));

        System.out.print(minimumEffortPath1(arr));
    }

    public static int bestMinimumEffortPath1(int[][] heights) {

        Pair end = new Pair(heights.length-1, heights[0].length-1, 0);

        boolean[][] visited = new boolean[heights.length][heights[0].length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0, 0));

        while(!pq.isEmpty()) {
            Pair rem = pq.remove();

            int[][] shifts = { {0,1},{0,-1},{1,0}, {-1,0} };

            if(rem.equals(end)) {
                return rem.maxAbsDiff;
            }

            if(visited[rem.x][rem.y]) continue;
            visited[rem.x][rem.y] = true;

            for(int[] s: shifts) {
                int next_x = rem.x + s[0];
                int next_y = rem.y + s[1];
                if(next_x >= 0 && next_x < heights.length && next_y >= 0 && next_y < heights[0].length && !visited[next_x][next_y]) {
                    int currMaxAbsDiff = Math.max( rem.maxAbsDiff, Math.abs(heights[rem.x][rem.y] - heights[next_x][next_y]));
                    pq.add(new Pair(next_x, next_y, currMaxAbsDiff));
                }
            }



        }
        return -1;
    }


    //Takes more time because it tries to explore many paths : it has been improved by using res as static var and currDiff criteria in isFeasible method
    public static int minimumEffortPath1(int[][] heights) {

        res[0] = Integer.MAX_VALUE;

        boolean[][] visited = new boolean[heights.length][heights[0].length];
        visited[0][0] = true;

        findMinPathEffort(heights, new Pair(0,0, 0), new Pair(heights.length-1, heights[0].length-1, 0), visited, res );
        return res[0];
    }

    private static void findMinPathEffort(int[][] heights, Pair curr, Pair end, boolean[][] visited,int[] res) {

        if(curr.equals(end)) {
            if(res[0] > curr.maxAbsDiff) {
                res[0] = curr.maxAbsDiff;
            }
            return;
        }

        int[][] shifts = { {0,1},{0,-1},{1,0}, {-1,0} };

        for(int[] s: shifts) {
            int next_x = curr.x + s[0];
            int next_y = curr.y + s[1];
            if(isFeasible(heights,next_x, next_y, visited, curr.maxAbsDiff)) {
                int currMaxAbsDiff = Math.max( curr.maxAbsDiff, Math.abs(heights[curr.x][curr.y] - heights[next_x][next_y]));
                visited[next_x][next_y] = true;
                findMinPathEffort(heights, new Pair(next_x, next_y, currMaxAbsDiff), end, visited, res);
                visited[next_x][next_y] = false;
            }
        }
    }

    private static boolean isFeasible(int[][] heights, int x, int y, boolean[][] visited , int currDiff){
        return x >= 0 && x < heights.length && y >= 0 && y < heights[0].length && !visited[x][y] && currDiff < res[0];
    }

    private static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int maxAbsDiff;

        Pair (int x, int y, int maxAbsDiff) {
            this.x = x;
            this.y = y;
            this.maxAbsDiff = maxAbsDiff;
        }


        public boolean equals(Object other) {
            if( other instanceof Pair) {
                Pair o = (Pair)other;
                if(this.x == o.x && this.y == o.y){
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Pair o) {
            return this.maxAbsDiff - o.maxAbsDiff;
        }
    }
}

package programming.level2;

import java.util.ArrayDeque;

/**
 *  Created by avinashkumarmishra on 05/04/22.
 *
 *  Print All Minimum Cost Paths Dynamic Programming | Minimum Cost Path
 *
 *
 **/

public class problem72 {

    public static void main(String[] args) {

        int[][] inp = {{2,6,1,1,3},{9,1,1,0,5},{0,7,5,2,0},{4,3,0,4,7},{2,0,1,4,1}};

        printAllPaths(inp);
    }

    private static void printAllPaths(int[][] cost) {

        int[][] dp = new int[cost.length][cost[0].length];

        for(int row = cost.length-1; row >=0 ; row--) {
            for(int col = cost[row].length-1; col >= 0; col--) {

                if(col == cost[row].length -1 && row == cost.length-1) {
                    dp[row][col] = cost[row][col];
                }
                else if(col == cost[row].length -1) {
                    dp[row][col] = cost[row][col] + dp[row+1][col];
                }  else if(row == cost.length -1) {
                    dp[row][col] = cost[row][col] + dp[row][col+1];
                } else {
                    dp[row][col] = cost[row][col] + Math.min(dp[row+1][col],dp[row][col+1]);
                }
            }
        }

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair("",0,0));

        while(q.size() > 0) {
            Pair r = q.remove();

            if(r.x == dp.length-1 && r.y == dp[0].length-1) {
                System.out.println(r.psf);
            }else if(r.x == dp.length-1) {
                q.add(new Pair(r.psf+"H",r.x, r.y+1));
            }else if(r.y == dp[0].length-1) {
                q.add(new Pair(r.psf+"V",r.x+1, r.y));
            }else{
                if(dp[r.x][r.y+1] < dp[r.x+1][r.y]) {
                    q.add(new Pair(r.psf+"H",r.x, r.y+1));
                } else if(dp[r.x][r.y+1] > dp[r.x+1][r.y]) {
                    q.add(new Pair(r.psf+"V",r.x+1, r.y));
                } else {
                    q.add(new Pair(r.psf+"H",r.x, r.y+1));
                    q.add(new Pair(r.psf+"V",r.x+1, r.y));
                }
            }
        }
    }

    private static class Pair {
        String psf;
        int x;
        int y;

        public Pair(String psf, int x, int y) {
            this.psf = psf;
            this.x = x;
            this.y = y;
        }
    }
}
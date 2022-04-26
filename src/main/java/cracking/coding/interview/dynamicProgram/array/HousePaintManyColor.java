package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinash on 18/04/2022.
 */
public class HousePaintManyColor {


    public static void main(String[] args) {

        int[][] paintCost = {{1, 5, 7, 2, 1, 4}, {5,8,4,3,6,1}, {3,2,9,7,2,3}, {1,2,4,9,1,7}};

        // n^3
        System.out.println(getMinPaint(paintCost));


        // n^2
        System.out.println(getMinPaintBest(paintCost));
    }


    // n^2
    private static long getMinPaintBest(int[][] colors) {

        long[][] dp = new long[colors.length][colors[0].length];
        long minResult = Integer.MAX_VALUE;

        MinVal currFirstMin = new MinVal(), prevFirstMin = new MinVal();
        MinVal currSecondMin = new MinVal(), prevSecondMin = new MinVal();

        for(int i = 0; i < dp.length; i++) {

            currFirstMin = new MinVal();
            currSecondMin = new MinVal();

            for(int j = 0; j < dp[0].length; j++) {

                if(i == 0) {
                    dp[i][j] = colors[i][j];
                } else {
                   if(prevFirstMin.idx == j) {
                       dp[i][j] = colors[i][j] + prevSecondMin.val;
                   } else {
                       dp[i][j] = colors[i][j] + prevFirstMin.val;
                   }
                }
               if(currFirstMin.val > dp[i][j]) {
                   currSecondMin = currFirstMin;

                   currFirstMin = new MinVal();
                   currFirstMin.idx = j;
                   currFirstMin.val = dp[i][j];
               } else if(currSecondMin.val > dp[i][j]) {

                   currSecondMin.idx = j;
                   currSecondMin.val = dp[i][j];
               }

            }
            prevFirstMin = currFirstMin;
            prevSecondMin = currSecondMin;
        }
        return currFirstMin.val;
    }

    private static class MinVal {
        int idx;
        long val;

        MinVal() {
            this.idx = -1;
            this.val = Integer.MAX_VALUE;
        }


    }


    // n^3
    private static long getMinPaint(int[][] colors) {

        long[][] dp = new long[colors.length][colors[0].length];
        long minResult = Integer.MAX_VALUE;;

        for(int i = 0; i < dp.length; i++) {

            for(int j = 0; j < dp[0].length; j++) {

                if(i == 0) {
                    dp[i][j] = colors[i][j];
                } else {
                    long minVal = Integer.MAX_VALUE;
                    for(int k = 0; k < dp[0].length; k++) {
                        if(k != j) {
                            minVal = Math.min(dp[i - 1][k], minVal);
                        }
                    }
                    dp[i][j] = colors[i][j] + minVal;
                }
                //last row
                if(i == dp.length-1) {
                    minResult = Math.min(dp[i][j], minResult);
                }

            }
        }
        return minResult;
    }
}

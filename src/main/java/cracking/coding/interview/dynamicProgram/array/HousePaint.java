package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 22/10/21.
 * 2022
 */
public class HousePaint {

    public static void main(String[] args) {

        int noOfHouses = 4;

        int[][] paintCost = {{1,5,7}, {5,8,4}, {3,2,9}, {1,2,4}};

        System.out.print(getMinimumCost(paintCost));
    }

    private static long getMinimumCost(int[][] paintCost){
        long[][] dp = new long[paintCost.length][3];


        dp[0][0] = paintCost[0][0];
        dp[0][1] = paintCost[0][1];
        dp[0][2] = paintCost[0][2];

        for(int i = 1; i< dp.length; i++) {
            dp[i][0] = paintCost[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = paintCost[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);;
            dp[i][2] = paintCost[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);;
        }

        return Math.min(dp[paintCost.length - 1][0], Math.min(dp[paintCost.length - 1][1], dp[paintCost.length - 1][2]));
    }


}

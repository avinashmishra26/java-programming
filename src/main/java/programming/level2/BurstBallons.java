package programming.level2;

/**
 * Created by avinash on 01/05/2022.
 */
public class BurstBallons {


    public static void main(String[] args) {

        int[] inp = {2,3,1,5,6,4};

        System.out.print(maxCoins(inp));
    }


    public static int maxCoins(int[] nums) {

        int[][] dp = new int[nums.length][nums.length];

        for(int g = 0; g < nums.length; g++) {
            for(int i = 0 , j = g; j < nums.length; i++, j++) {

                int k = i, tempMax = Integer.MIN_VALUE;

                for(k = i; k <= j; k++) {

                    int left = k == i ? 0 : dp[i][k-1];
                    int right = k == j ? 0 : dp[k+1][j];

                    int lMul = i == 0 ? 1 :  nums[i-1];
                    int rMul = j == nums.length -1 ? 1 :  nums[j+1];

                    int tMax = left + right + lMul*nums[k]*rMul;

                    tempMax = Math.max(tempMax, tMax);
                }
                dp[i][j] = tempMax;

            }
        }
        return dp[0][nums.length - 1];

    }
}

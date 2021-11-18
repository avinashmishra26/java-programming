package elementsofProgramming.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 20/09/21.
 */
public class MaximumGoldThiefProblem {

    public static void main(String[] args) {
        List<Integer> gold = Arrays.asList( 5, 4, 1, 3);
        System.out.println(maxGold(gold));
        System.out.print(maxLoot(new int[]{5, 4, 1, 3},4));
    }

    private static int maxGold(List<Integer> housesStart) {

        if (housesStart.isEmpty()) {
            return 0;
        }
        if (housesStart.size() == 1) {
            return housesStart.get(0);
        }

        int val1 =  housesStart.get(0);

        if (housesStart.size() > 2)
            val1 += maxGold(housesStart.subList(2, housesStart.size()));

        int val2 =  housesStart.get(1);

        if (housesStart.size() > 3)
            val2 += maxGold(housesStart.subList(3, housesStart.size()));

        return val1 > val2 ? val1 : val2;
    }

    // Function to calculate the maximum stolen value
    static int maxLoot(int hval[], int n)
    {
        if (n == 0)
            return 0;
        if (n == 1)
            return hval[0];
        if (n == 2)
            return Math.max(hval[0], hval[1]);

        // dp[i] represent the maximum value stolen
        // so far after reaching house i.
        int[] dp = new int[n];

        // Initialize the dp[0] and dp[1]
        dp[0] = hval[0];
        dp[1] = Math.max(hval[0], hval[1]);

        // Fill remaining positions
        for (int i = 2; i<n; i++)
            dp[i] = Math.max(hval[i] + dp[i-2], dp[i-1]);

        return dp[n-1];
    }
}

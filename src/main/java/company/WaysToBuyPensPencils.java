package company;

/**
 * Created by avinash on 16/04/2022.
 */
public class WaysToBuyPensPencils {


    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long[] dp = new long[total+1];
        dp[0] = 0;

        int t1 = cost1, t2 = cost2;
        cost1 = t1 < t2 ? t1 : t2;
        cost2 = t1 > t2 ? t1 : t2;

        //for cost1
        for(int i = 1; i <= total; i++) {
            if(i >= cost1) {
                dp[i] = dp[i-cost1] + 1;
            } else {
                dp[i] = dp[i-1];
            }
        }

        //for cost2
        for(int i = 1; i <= total; i++) {
            if(i >= cost2) {
                dp[i] += dp[i-cost2] + 1;
            }
        }
        return dp[total] +1;

    }
}

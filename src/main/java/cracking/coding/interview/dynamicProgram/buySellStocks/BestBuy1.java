package cracking.coding.interview.dynamicProgram.buySellStocks;

/**
 * Created by avinashkumarmishra on 11/11/21.
 *  Only 1 Transaction is allowed find maximum
 */
public class BestBuy1 {

    public static void main(String[] args) {
        System.out.print(bestBuy(new int[]{7,1,5,3,6,4}));

    }

    private static int bestBuy(int[] stockPrice) {

        int profit = 0;

        int todayProfit = 0;

        int leastPrice = stockPrice[0];

        for(int i = 0 ; i < stockPrice.length; i++) {

            if(stockPrice[i] < leastPrice) {
                leastPrice = stockPrice[i];
            }

            todayProfit = stockPrice[i] - leastPrice;

            if(todayProfit > profit) {
                    profit = todayProfit;
            }

        }

        return profit;

    }
}

package cracking.coding.interview.dynamicProgram.buySellStocks;

/**
 * Created by avinashkumarmishra on 11/11/21.
 *
 * Infinite Transactions is allowed find total
 *
 * profit for all upstrokes
 *
 */
public class BestBuy2InfiniteTransaction {

    public static void main(String[] args) {
        System.out.print(calculateProfit(new int[]{2,4,5, 3,1,3,5,6,6, 7, 5, 7}));
    }

    private static int calculateProfit(int[] stockPrice) {

        int totalProfit = 0, i = 0;

        int lowestPrice = Integer.MAX_VALUE;

        int highestPrice = Integer.MIN_VALUE;

        while(i < stockPrice.length) {

            lowestPrice = highestPrice = stockPrice[i++];

            while(i < stockPrice.length && lowestPrice > stockPrice[i]) {
                lowestPrice = stockPrice[i];
                highestPrice = stockPrice[i];
                i++;
            }


            while(i < stockPrice.length && highestPrice <= stockPrice[i]) {
                highestPrice = stockPrice[i];
                i++;
            }

            if(i < stockPrice.length) {
                totalProfit += (highestPrice - lowestPrice);
            }

        }

        totalProfit += (highestPrice - lowestPrice);

        return totalProfit;
    }
}

package elementsofProgramming.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 07/10/21.
 * Repetition is not allowed.
 * Items are present with weight and value and we have to fill the bag to the capacity.
 * Here we have items ( weight, value)
 * Item(2,15), Item(5,14), Item(1,10), Item(3,45), Item(4,30)
 * and the bag capacity is 7
 * Max Value generate
 * 2022
 */
public class problem6_Knapsack {

    public static void main(String[] args) {
        System.out.print(optimalStratergyKnapsack(Arrays.asList(new Item(2,15), new Item(5,14), new Item(1,10), new Item(3,45), new Item(4,30)),7));
    }

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static int optimalStratergyKnapsack(List<Item> items, int capacity){

        items = new ArrayList<Item>(items);
        items.add(0, new Item(0,0));

        int[][] dp = new int[items.size()][capacity+1];

        for(int i = 0; i < items.size() ; i++) {
            for ( int j = 0; j <= capacity ; j++) {
                if ( i == 0) {
                    dp[i][j] = 0;
                } else if ( j == 0) {
                    dp[i][j] = 0;
                } else {
                    Item item = items.get(i);
                    int oldVal = dp[i-1][j];

                    if (item.weight <= j) {
                        int newVal = dp[i-1][j-item.weight] + item.value;
                        dp[i][j] = Math.max(newVal , oldVal);
                    } else {
                        dp[i][j] = oldVal;
                    }
                }
            }
        }
        return dp[items.size() - 1][capacity];
    }
}

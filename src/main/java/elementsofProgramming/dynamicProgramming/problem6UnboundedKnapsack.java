package elementsofProgramming.dynamicProgramming;

import java.util.Arrays;
import java.util.List;

/**
 * Created by avinashkumarmishra on 08/10/21.
 * Repetition is allowed
 * Items are present with weight and value and we have to fill the bag to the capacity.
 * Here we have items ( weight, value)
 * Item(2,15), Item(5,14), Item(1,10), Item(3,45), Item(4,30)
 * and the bag capacity is 7
 *
 */
public class problem6UnboundedKnapsack {

    public static void main(String[] args) {
        System.out.print(optimalStratergyUnboundedKnapsack(Arrays.asList(new Item(2,15), new Item(5,14), new Item(1,10), new Item(3,45), new Item(4,30)),7));
    }

    private static class Item {
        public Integer weight;
        public Integer value;

        public Item(Integer weight, Integer value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int optimalStratergyUnboundedKnapsack(List<Item> items, int capacity) {

        int[] dp = new int[capacity+1];
        int temp = Integer.MIN_VALUE;

        for ( int i = 1 ; i < dp.length; i++) {
            for(Item item : items) {
                if(item.weight <= i) {
                    temp = item.value + dp[i - item.weight];
                }
                if (temp > dp[i]) {
                    dp[i] = temp;
                }
            }
        }
        return dp[capacity];
    }
}

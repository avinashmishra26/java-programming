package cracking.coding.interview;

import cracking.coding.interview.BinaryStringsWithNoConsecutiveZeros;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * In how many ways we can built house on both side of a road where
 * either B = Building or S = Space is allowed in a block and 2 building can not be adjacent to each other
 * It is similar to problem where we can not have 2 zeros in a binary string and then square the result.
 */
public class ArrangeBuildingsDynamicProgramming {

    public static void main(String[] args) {
        int oneRoad = BinaryStringsWithNoConsecutiveZeros.getBSCount(5);
        int tworoad = oneRoad*oneRoad;
        System.out.print(tworoad);
    }

}

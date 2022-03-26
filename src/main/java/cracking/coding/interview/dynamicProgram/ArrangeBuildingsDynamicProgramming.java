package cracking.coding.interview.dynamicProgram;

import cracking.coding.interview.dynamicProgram.BinaryStringsWithNoConsecutiveZeros;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * In how many ways we can built house on both side of a road with
 * either B = Building or S = Space, where space is allowed in a block of 2 but
 * buildings can not be adjacent to each other
 *
 * It is similar to problem where we can not have 2 zeros in a binary string
 * and then square/double the result.
 *
 * 2022
 */
public class ArrangeBuildingsDynamicProgramming {

    public static void main(String[] args) {
        int oneRoad = BinaryStringsWithNoConsecutiveZeros.getBSCount(5);
        int tworoad = oneRoad*oneRoad;
        System.out.print(tworoad);
    }

}

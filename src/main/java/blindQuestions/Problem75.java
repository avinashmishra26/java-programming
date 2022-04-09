package blindQuestions;

/**
 *
 * Do XOR and AND << 1 and loop until AND is 0
 *
 * Blind-75 - Sum of Two Integers - Leetcode 371 - Java
 */

public class Problem75 {


    public static void main(String[] args) {
        System.out.print(sum(9,11));
    }

    private static int sum(int a, int b) {


        while(b != 0) {
            int temp = (a & b) << 1;
            a = a ^ b;
            b = temp;

        }

        return a;
    }


}
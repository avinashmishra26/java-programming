package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 14/02/22.
 */

public class PrintDecreasingIncreasing {

    public static void main(String[] args) {
        printDecreasingN(5);

        System.out.println();
        printIncreasingN(5);

        System.out.println();
        printDecreasingIncreasingN(5);

    }

    private static void printDecreasingN(int n) {
        if (n == 0) return ;

        System.out.print(n + " ");
        printDecreasingN(n-1);
    }

    private static void printIncreasingN(int n) {
        if (n == 0) return ;

        printIncreasingN(n-1);
        System.out.print(n + " ");
    }

    private static void printDecreasingIncreasingN(int n) {
        if (n == 0) return ;

        System.out.print(n + " ");
        printDecreasingIncreasingN(n-1);
        System.out.print(n + " ");
    }
}
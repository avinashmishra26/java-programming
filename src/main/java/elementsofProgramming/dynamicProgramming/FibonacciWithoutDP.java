package elementsofProgramming.dynamicProgramming;

/**
 *  Created by avinashkumarmishra on 27/09/21.
 *
 *  Minimizing cache space is a recurring theme in DP. Now we show a program that
 *  computes F(n) in 0(n) time and 0(1) space. Conceptually, in contrast to the above
 *  program, this program iteratively fills in the cache in a bottom-up fashion, which
 *  allowsit to reuse cache storage to reduce the space complexity of the cache.
 *
 *  2022
 */
public class FibonacciWithoutDP {

    public static void main(String[] args) {

        System.out.println(fibonacci(10));

        System.out.println(fibRecurrsive(9));

    }

    //good approach
    public static int fibonacci(int n) {

        int a = 0, b = 1, c = 0;

        if (n <= 1) {
            return n-1;
        }

        for (int i= 3; i<=n ; i++) {
            c = a+b;
            a = b;
            b = c;
        }

        return c;
    }

    //recursive bad approach
    private static int fibRecurrsive(int n) {
        if(n <= 1) return n;
        else {
            return fibRecurrsive(n - 1) + fibRecurrsive(n - 2);
        }
    }
}

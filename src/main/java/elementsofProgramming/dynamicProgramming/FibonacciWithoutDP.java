package elementsofProgramming.dynamicProgramming;

/**
 *  Created by avinashkumarmishra on 27/09/21.
 *
 *  Minimizing cache space is a recurring theme in DP. Now we show a program that
 *  computes F(n) in 0(n) time and 0(1) space. Conceptually, in contrast to the above
 *  program, this program iteratively fills in the cache in a bottom-up fashion, which
 *  allowsit to reuse cache storage to reduce the space complexity of the cache.
 *
 */
public class FibonacciWithoutDP {

    public static void main(String[] args) {

        System.out.print(fibonacci(10));

    }

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
}

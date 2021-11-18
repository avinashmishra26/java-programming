package elementsofProgramming.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 *  Created by avinashkumarmishra on 27/09/21.
 *  Caching intermediate results makes the time complexity for computing the nth
 *  Fibonacci number linear in O(n) at the expense of 0(n) sapce complexity.
 */
public class FibonacciWithDP {

    static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public static void main(String[] args) {


        fibonacci(7);

        System.out.print(map.get(7));
    }

    private static int fibonacci(int n) {

        if (n <= 1) {
            return n;
        }

        if (!map.containsKey(n)) {
            map.put(n, fibonacci(n-1) + fibonacci(n-2));
        }
        return map.get(n);
    }
}

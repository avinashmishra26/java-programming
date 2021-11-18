package elementsofProgramming.miscellaneous;

import java.util.Collections;

/**
 * Created by avinashkumarmishra on 14/10/21.
 */
public class GCD {

    public static void main(String[] args) {

        System.out.print(getGCD(5,6));

    }

    private static int getGCD(int x, int y) {

        int x1 = x > y ? x : y;
        int y1 = x > y ? y : x;

        while( x1 != y1 ) {

            x1 = x1 - y1;
            if ( x1 < y1) {
                int temp = x1;
                x1 = y1;
                y1 = temp;
            }


        }

        return x1;
    }
}

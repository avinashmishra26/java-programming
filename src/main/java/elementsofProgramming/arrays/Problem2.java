package elementsofProgramming.arrays;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 24/09/21.
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] a = incrmentByOne(new int[]{9,9,9});

        for ( int a1 : a)
            System.out.print(a1 +" ");
    }

    private static int[] incrmentByOne(int[] a) {

        int carry = 1, temp = 0;
        for ( int j = a.length - 1; j>= 0; j--) {
            temp = a[j] + carry;
            a[j] = temp % 10;
            carry = temp / 10;
            if (carry != 1)
                break;
        }

        if (carry == 1) {
            int[] newarr = new int[a.length + 1];
            newarr[0] = 1;
            System.arraycopy(newarr, 1, a, 0, a.length);
            return newarr;
        }
        return a;
    }
}

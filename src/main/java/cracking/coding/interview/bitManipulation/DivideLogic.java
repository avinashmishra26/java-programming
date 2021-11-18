package cracking.coding.interview.bitManipulation;

/**
 * Created by avinashkumarmishra on 10/11/21.
 *
 *  Solve 7*n/8 then transform it to (8*n -1 ) / 8
 */
public class DivideLogic {

    public static void main(String[] args) {

        int n = 5;

        int res = ((n << 3) - n) >> 3;

        System.out.print(res);
    }
}

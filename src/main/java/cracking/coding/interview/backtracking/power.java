package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 14/02/22.
 */

public class power {

    public static void main(String[] args) {

        System.out.println(power(2, 5));

        System.out.print(logsrithmPower(10L,7));
    }

    private static int power(int x, int n) {
        if (n == 1) return x;
        else return x*power(x, n-1);
    }

    private static Long logsrithmPower(Long x, int n) {
        if( n == 1) return x ;

        Long tRes = logsrithmPower(x, n/2);
        Long res = tRes * tRes;

        if(n % 2 == 1) {
            res *= x;
        }
        return res;
    }
}
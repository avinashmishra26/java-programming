package cracking.coding.interview;

/**
 * Created by avinashkumarmishra on 12/10/21.
 */
public class ReverseInt {

    public static void main(String[] args) {
        System.out.print(reverse(1534236469));
    }

    public static int reverse(int x) {
        boolean isNegative = false;
        int res = 0;
        if ( x < 0) {
            isNegative = true;
            x *= (-1);
        }
        while(x>0) {
            if(isOutofRange(((long)res)*10, x%10, isNegative)){
                return 0;
            }
            res = res*10 + x % 10;
            x = x/10;
        }
        return isNegative ? -res : res;
    }

    private static boolean isOutofRange(long prev, long val, boolean isNegative) {
        if(isNegative) {
            return (prev+val) >= Math.pow(2,31);
        }
        return (prev+val) >= (Math.pow(2,31) - 1);
    }
}

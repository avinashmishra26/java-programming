package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 04/10/21.
 * INTERCONVERT STRINGS AND INTEGERS
 */
public class Problem1 {

    public static void main(String[] args) {

        System.out.println(convertStringToInt("-123"));
        System.out.println(convertStringToInt("123"));


        System.out.println(convertIntToString(-123));
    }

    public static int convertStringToInt(String s) {

        int i = 0, sum = 0; boolean isNegative = false;


        if (s.charAt(i) == '-'){
            i = 1;
            isNegative = true;
        }

        for( ; i < s.length() ; i++) {
            sum = sum*10 + (s.charAt(i) - '0');
        }

        if(isNegative) {
            sum *= -1;
        }
        return sum;
    }


    public static String convertIntToString(int s) {

        boolean isNegative = false;
        StringBuilder res = new StringBuilder();

        if ( s < 0) {
            isNegative = true;
            s *= -1;
        }

        while(s > 0) {
            res.append(s % 10);
            s /= 10;
        }

        if(isNegative) {
            res.append('-');
        }

        return res.reverse().toString();
    }


}
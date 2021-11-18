package cracking.coding.interview.dynamicProgram.catalanNumber;

/**
 * Created by avinashkumarmishra on 14/11/21.
 *
 * Number of count of balanced pair of parenthesis
 *
 * For 1 pair -> count = 1    -> ()
 * For 2 pair -> count = 2    -> ()() , (())
 *
 * For 3 Pair -> count 5     -> (()()),((())),  (())(), ()()(), ()(()),
 *
 */
public class CombinationOfBalancedParenthesis {


    public static void main(String[] args) {

        //here 4 is the pair of parenthesis we are passing as the argument
        System.out.print(getCountOfParentesisPairPossible(4));
    }

    private static int getCountOfParentesisPairPossible(int n) {

        int[] dp = new int[n+1];

        dp[0] = dp[1]= 1;

        for(int i = 2; i <=n; i++){

            for(int j = 0; j < i; j++) {
                dp[i] += dp[j]*dp[i-j-1];
            }
        }
        return  dp[n];
    }
}

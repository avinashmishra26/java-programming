package elementsofProgramming.dynamicProgramming;

/**
 * Created by avinashkumarmishra on 07/11/21.
 */
public class Problem4 {

    public static void main(String[] args) {
        int[][] res = new int[5+1][2+1];
        computeBinomialCoefficient(5, 2, res);

        System.out.print(res[5][2]);
    }


    public static int computeBinomialCoefficient(int n, int k, int[][] res) {

        if(n == k) {
            return 1;
        } else if( k == 1){
            return n;
        }

        if(res[n][k] > 0) {
            return res[n][k];
        }

        int left = computeBinomialCoefficient(n-1, k, res);
        int right = computeBinomialCoefficient(n-1, k-1, res);

        res[n][k] = left+right;

        return res[n][k];
    }
}

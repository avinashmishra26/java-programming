package cracking.coding.interview.binarySearchtree;

/**
 * Created by avinashkumarmishra on 08/11/21.
 * Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.
 *
 * https://leetcode.com/problems/unique-binary-search-trees/
 *
 * Input: n = 3
   Output: 5

 *  Catalan Problem (also refered in catalan package : cracking.coding.interview.binarySearchtree.NumofTrees)
 *
 *
 */
public class NumofTrees {

    public static void main(String[] args) {
        System.out.print(getNumberOfBSTs(4));
    }

    public static int getNumberOfBSTs(int n) {
        int[] dp = new int[n+1];

        for(int i = 0; i <= n ; i++) {

            if(i == 0 || i ==1) {
                dp[i] = 1;
            } else if (i == 2){
                dp[i] = 2;
            }else {
                int cnt = 0;
                for(int k = 1; k <=i; k++) {

                    int left = dp[k-1];
                    int right = dp[i-k];

                    cnt += (left*right);
                }
                dp[i] = cnt;
            }
        }
        return dp[n];
    }
}

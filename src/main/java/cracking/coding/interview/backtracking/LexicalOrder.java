package cracking.coding.interview.backtracking;

import java.util.*;

/**
 * Created by avinashkumarmishra on 23/10/21.
 */
public class LexicalOrder {

    public static void main(String[] args) {
        lexicalOrder(1000).forEach(e -> System.out.print(e +" "));
    }

    public static List<Integer> lexicalOrder(int n) {

        List<Integer> res = new ArrayList();
        getlexicalOrder(n, res, 0);
        return res;
    }

    private static void getlexicalOrder(int n, List<Integer> res, int prev){


        for ( int i = 0; i <= 9; i++) {
            int curr = prev*10 + i;
            if(curr > 0 && curr <= n) {
                res.add(curr);
                getlexicalOrder(n, res, curr);
            }
            if (curr > n){
                return;
            }
        }
    }
}

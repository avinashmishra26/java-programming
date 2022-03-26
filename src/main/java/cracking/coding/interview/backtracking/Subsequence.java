package cracking.coding.interview.backtracking;

/* Created by avinashkumarmishra on 22/03/22.
*  2022
*
*  Subsequence of Strings
*/

import java.util.ArrayList;
import java.util.List;

public class Subsequence {

    public static void main(String[] args) {

        List<String> res = new ArrayList<>();

        String input = "abc";

        getAllSubsequence(input, 0, "", res);

        res.forEach(e -> System.out.println(e));

        System.out.println("total subsequence "+res.size());

        // try with the below string in the first method
        // to see the issue at your own risk :(
        getAllSubsequenceBest("abcerqwsdfgdderghuioljgfdcvgbnhy", 0, "");
    }

    private static void getAllSubsequence(String input,int idx,
                                          String ssf,
                                          List<String> res) {

        if(input.length() == idx) {
            res.add(ssf.toString());
            return;
        }

        getAllSubsequence(input, idx+1, ssf + input.charAt(idx), res);

        getAllSubsequence(input, idx+1, ssf, res);


    }

    //memory efficient if string is long like 31 character because it
    // requires 32GB Ram which we don't have (considering each character
    // is 1 byte). Storing all strings can be sometimes Out-of-memory issue
    private static void getAllSubsequenceBest(String input, int idx, String ssf) {

        if(input.length() == idx) {
            System.out.println(ssf.toString());
            return;
        }

        getAllSubsequenceBest(input, idx+1, ssf + input.charAt(idx));

        getAllSubsequenceBest(input, idx+1, ssf);

    }
}
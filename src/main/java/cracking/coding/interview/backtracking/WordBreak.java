package cracking.coding.interview.backtracking;

import java.util.HashSet;

/**
 * Created by avinashkumarmishra on 07/04/22.
 *
 *  print all possible WordBreak
 *
 */


public class WordBreak {

    public static void main(String[] args) {
        String s = "microsofthiring";

        HashSet<String> set = new HashSet<>();
        set.add("micro");
        set.add("soft");
        set.add("hi");
        set.add("ring");
        set.add("microsoft");
        set.add("hiring");

        wordBreak(s, set, "");


        String test = "t";
        System.out.print(test.substring(1));
    }

    private static void wordBreak(String s, HashSet<String> dict, String psf) {

        if(s.length() == 0) {
            System.out.println(psf);
            return;
        }

        for(int i = 0; i < s.length(); i++) {

            if(dict.contains(s.substring(0, i+1))) {

                String str = s.substring(i+1) != null ? s.substring(i+1) : "";

                wordBreak(str, dict, psf+s.substring(0, i+1)+" ");
            }

        }
    }

}
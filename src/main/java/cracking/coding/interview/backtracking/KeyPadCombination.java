package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 24/03/22.
 */

import java.util.*;

public class KeyPadCombination {

    static String[] codes = { ".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static void main(String[] args) {
        List l = getKPC("673", 0);
        System.out.println(l);

        System.out.println(l.size());

        printKPC("673", 0, "");
    }

    private static void printKPC(String ques, int idx, String ssf) {

        if(idx == ques.length()) {
            System.out.print(ssf + " ");
            return;
        }

        int ch = ques.charAt(0) - '0';

        for(char c : codes[ch].toCharArray()) {
            printKPC(ques, idx+1, ssf+c);
        }


    }

    private static ArrayList<String> getKPC(String input, int idx) {

        if(idx == input.length()) {

            ArrayList<String> r = new ArrayList<>();
            r.add("");

            return r;
        }

        int n = input.charAt(idx) - '0';


        ArrayList<String> pRes = getKPC(input, idx+1);

        ArrayList<String> res = new ArrayList<>();

        for(char c : codes[n].toCharArray()) {

            for(String p : pRes) {
                res.add(c+p);
            }
        }

        return res;
    }
}
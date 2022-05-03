package company;

import java.util.Stack;

/**
 * Created by avinash on 01/05/2022.
 */
public class BackspaceStringCompare {


    public static void main(String[] args) {
        String s = "ab##";
        String t =  "c#d#";


        System.out.print(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> first = insertStk(s);
        Stack<Character> second = insertStk(t);

        while(first.size() > 0 && second.size() > 0) {
            if(first.pop() != second.pop()) {
                return false;
            }
        }

        return first.empty() && second.empty() ? true : false;

    }

    private static Stack<Character>  insertStk(String str) {

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if(temp == '#') {
                if(stk.size() > 0)
                    stk.pop();
            } else {
                stk.push(temp);
            }
        }
        return stk;
    }


}

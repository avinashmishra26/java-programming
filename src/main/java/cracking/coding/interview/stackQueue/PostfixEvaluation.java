package cracking.coding.interview.stackQueue;


/**
 * Created by avinashkumarmishra on 02/04/22.
 *
 * Celebrity Problem
 *
 */

import java.util.Stack;

public class PostfixEvaluation {

    public static void main(String[] args) {

        System.out.print(getValue("2367*6/++2+"));
    }

    private static int getValue(String postfixExp) {

        Stack<Integer> res = new Stack<>();

        for(int i = 0; i < postfixExp.length(); i++) {
            char c = postfixExp.charAt(i);

            if(Character.isDigit(c)) {
                res.push(c - '0');
            } else {
                int v2 = res.pop();
                int v1 = res.pop();

                res.push(operation(v1, v2, c));
            }
        }
        return res.peek();
    }

    private static int operation(int v1, int v2, char op) {
        switch (op) {
            case '+' : return v1+v2;
            case '*' : return v1*v2;
            case '-' : return v1-v2;
            case '/' : return v1/v2;
            default: return -1;
        }
    }
}
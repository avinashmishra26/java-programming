package cracking.coding.interview.stackQueue;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 01/04/22.
 * 2022
 *
 * Evaluate : 2 + (5 -3 * 6 / 2)
 */

public class InfixEvaluation {

    public static void main(String[] args) {
        System.out.print(getInfixEval("2+(3+6*7/6)+2"));
    }

    private static int getInfixEval(String exp) {

        Stack<Integer> nums = new Stack<>();

        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if(ch == '(') {
                operator.push(ch);
            } else if(Character.isDigit(ch)) {
                nums.push(ch - '0');
            } else if(ch == ')'){
                while(operator.peek() != '(') {
                    int v2 = nums.pop();
                    int v1 = nums.pop();

                    char oper = operator.pop();
                    nums.push(getResult(v1, v2, oper));
                }
                operator.pop();

            } else if( ch == '*' || ch == '/' || ch == '+' || ch == '-') {
                while(operator.size() > 0 && operator.peek() != '('  &&
                        getPrecedence(ch) <= getPrecedence(operator.peek())) {

                    int v2 = nums.pop();
                    int v1 = nums.pop();

                    char oper = operator.pop();
                    nums.push(getResult(v1, v2, oper));
                }

                operator.push(ch);
            }

        }

        while(operator.size() > 0) {
            int v2 = nums.pop();
            int v1 = nums.pop();

            char oper = operator.pop();
            nums.push(getResult(v1, v2, oper));
        }

        return nums.pop();

    }

    private static int getPrecedence(char optr) {
        if(optr == '+' || optr == '-') {
            return 1;
        } else  if(optr == '*' || optr == '/') {
            return 2;
        } else {
            return -1;
        }
    }

    private static int getResult(int v1, int v2, char operation) {
        if(operation == '+') {
            return v1+v2;
        } else if(operation == '-' ) {
            return v1-v2;
        }else  if(operation == '*') {
            return v1*v2;
        } else  if(operation  == '/') {
            return v1/v2;
        } else {
            return 0;
        }
    }
}
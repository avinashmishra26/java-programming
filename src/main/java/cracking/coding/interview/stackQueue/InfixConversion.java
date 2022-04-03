package cracking.coding.interview.stackQueue;


import java.util.Stack;

/**
 * Created by avinashkumarmishra on 01/04/22.
 * 2022
 *
 * Infix : 2 + (5 -3 * 6 / 2)
 *
 * convert to prefix and postfix
 *
 *      prefix [++2+3/*6762]
 *      postfix [2367*6/++2+]
 */

public class InfixConversion {

    public static void main(String[] args) {
        Stack <String> prefix = new Stack<>();
        Stack<String> postfix = new Stack<>();;

        convert("2+(3+6*7/6)+2", prefix, postfix);

        System.out.println("prefix " + prefix);

        System.out.println("postfix "+ postfix);
    }

    private static void convert(String infixExp , Stack <String> prefix, Stack<String> postfix) {

        Stack<Character> operator = new Stack<>();

        for(int i = 0; i < infixExp.length(); i++) {
            char c = infixExp.charAt(i);
            if(Character.isDigit(c)) {
                prefix.push(c+"");
                postfix.push(c+"");
            } else if ( c == '(') {
                operator.push(c);
            } else if(c == '+' || c == '-' || c == '*' || c == '/') {
                while(operator.size() > 0 && operator.peek() != '(' &&
                        getPrecedence(c) <= getPrecedence(operator.peek())) {
                    char operation = operator.pop();
                    String val2 = prefix.pop();
                    String val1 = prefix.pop();

                    prefix.push(operation + val1 + val2);

                    val2 = postfix.pop();
                    val1 = postfix.pop();

                    postfix.push(val1 + val2 + operation);
                }
                operator.push(c);
            } else if(c == ')') {
                while(operator.peek() != '('){

                    String val_2= prefix.pop();
                    String val_1 = prefix.pop();

                    char op = operator.pop();
                    prefix.push(op + val_1 + val_2);

                    val_2 = postfix.pop();
                    val_1 = postfix.pop();

                    postfix.push(val_1 + val_2 + op);
                }
                operator.pop();
            }

        }

        while(operator.size() > 0) {
            String val_2= prefix.pop();
            String val_1 = prefix.pop();

            char op = operator.pop();
            prefix.push(op + val_1 + val_2);

            val_2 = postfix.pop();
            val_1 = postfix.pop();

            postfix.push(val_1 + val_2 + op);
        }

    }

    private static int getPrecedence(char c) {
        if( c == '+') {
            return 1;
        } else if( c == '-'){
            return 1;
        } else if( c == '*') {
            return 2;
        } else if( c == '/') {
            return 2;
        }
        return -1;
    }
}
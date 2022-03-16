package cracking.coding.interview.stackQueue;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 12/03/22.
 *
 **/

public class DuplicateBracket {

    public static void main(String[] args) {
        System.out.println(isDuplicate("((a+b)+(c+d))"));

        System.out.println(isDuplicate("(a+b)+((c+d))"));

        System.out.println(isDuplicate("(x+((a+(b+c)))"));


        System.out.println();

        System.out.println(isDuplicateMethod("((a+b)+(c+d))"));

        System.out.println(isDuplicateMethod("(a+b)+((c+d))"));

        System.out.println(isDuplicateMethod("(x+((a+(b+c)))"));
    }

    //Better method because of space complexity
    private static boolean isDuplicateMethod(String exp) {

        Stack<Character> bracket = new Stack();

        for(int i = 0; i < exp.length(); i++) {
            char t = exp.charAt(i);

            if( t == ')') {
                if(bracket.peek() =='(') {
                    return true;
                }
                while(bracket.peek() != '('){
                    bracket.pop();
                }
                bracket.pop();

            } else {
                bracket.push(t);
            }
        }
        return false;
    }


    private static boolean isDuplicate(String exp) {
        Stack<Character> bracket = new Stack();

        Stack<Integer> openingBracketIdx = new Stack();

        for(int i = 0; i < exp.length(); i++) {
            char t = exp.charAt(i);

            if( t == '(' ) {
                bracket.push(t);
                openingBracketIdx.push(i);
            } else if ( t == ')' ) {

                if( (exp.length() > i+1 ) && exp.charAt(i+1) == ')' ) {
                    bracket.pop();

                    int t_1_Idx = openingBracketIdx.pop();

                    if(openingBracketIdx.size() > 0 ) {
                        int t_Idx = openingBracketIdx.peek();

                        if ((t_Idx + 1) == t_1_Idx) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;

    }
}
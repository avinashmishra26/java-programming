package elementsofProgramming.stack;

import java.util.*;

/**
 * Created by avinashkumarmishra on 08/10/21.
 */
public class TestApple {


    public static void main(String[] args) {
        System.out.print(isValidParentheses("*("));
    }


    private static int isValidParentheses(String str) {

        Deque<Integer> pair = new LinkedList<>();
        Deque<Integer> star = new LinkedList<>();

        if( str != null && str.length() <= 100) {

            for ( int i = 0; i < str.length(); i++) {
                char chr = str.charAt(i);
                if (chr == '(') {
                    pair.addFirst(i);
                } else if ( chr == ')' ){
                    if (!pair.isEmpty()) {
                        pair.removeFirst();
                    } else if ( !star.isEmpty() ) {
                        star.removeFirst();
                    } else {
                        return 0;
                    }
                } else if(chr == '*') {
                    star.addFirst(i);
                } else {
                    return 0;
                }
            }
            if (isBracketsBalance(pair, star)) {
                return 1;
            }

        }
        return 0;

    }


    private static boolean isBracketsBalance(Deque<Integer> pair, Deque<Integer> star) {

        while ( !pair.isEmpty()) {

            if (star.isEmpty()) {
                return false;
            }
            if ( pair.peekFirst() > star.peekFirst()){
                pair.removeFirst();
                star.removeFirst();
            } else {
                return false;
            }
        }
        return true;
    }
}

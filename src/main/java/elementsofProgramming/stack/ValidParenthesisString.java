package elementsofProgramming.stack;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 08/10/21.
 */
//Valid Parenthesis String with Star
public class ValidParenthesisString {
    public static boolean checkValidString(String s) {
        /*
        Declare two stacks,
        One for opening and closing bracket
        and other for star.
        */
        Stack<Integer> pair = new Stack<>();
        Stack<Integer> star = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
        //If it's opening bracket, push them in a stack
            if(ch =='(') {
                pair.push(i);
        /*
        If it's a star then push them in a second
        stack.
        */
            } else if (ch == '*') {
                star.push(i);
            } else {
        /*
        If the character is closing bracket, then
        there are three cases.
        i) If the first stack is not empty, first pop
        them from that stack.
        ii) If it's empty check in a second
        stack, Pop them from that.
        iii) If both of them empty then return false.
        */
                if(!pair.isEmpty()) {
                    pair.pop();
                } else if (!star.isEmpty()) {
                    star.pop();
                } else {
                    return false;
                }
            }
        }
        //Verify is it balanced
        return isBalanced(pair, star);
    }
    public static boolean isBalanced(Stack<Integer> pair, Stack<Integer> star) {
        while(!pair.isEmpty()) {
            if(star.isEmpty()) {
                return false;
            } else if(star.peek() > pair.peek()) {
                star.pop();  pair.pop();
            } else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "(*)";
        System.out.println(checkValidString(str));
    }
}
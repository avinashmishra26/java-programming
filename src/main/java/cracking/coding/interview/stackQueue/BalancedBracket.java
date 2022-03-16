package cracking.coding.interview.stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by avinashkumarmishra on 12/03/22.
 *
**/

public class BalancedBracket {

    public static void main(String[] args) {
        System.out.println(isBalanced("[(a+b)+{(c+d)*(e/f)}]"));


        System.out.println(isBalanced("[(a+b)+{(c+d)*(e/f)]}"));
    }

    private static boolean isBalanced(String exp) {

        Stack<Character> brackets = new Stack();

        Map<Character,Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for(int i = 0; i < exp.length(); i++) {

            char temp = exp.charAt(i);

            if(temp == '(' || temp == '{' || temp == '['){
                brackets.push(temp);
            } else if(bracketMap.containsKey(temp)) {
                if( (brackets.isEmpty()) ||
                        ((bracketMap.get(temp) != brackets.peek())))
                    return false;
                brackets.pop();
            }
        }
        if(brackets.isEmpty())
            return true;
        return false;
    }
}
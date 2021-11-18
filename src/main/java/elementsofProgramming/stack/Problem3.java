package elementsofProgramming.stack;

import java.util.*;

/**
 * Created by avinashkumarmishra on 20/09/21.
 *
 * TEST A STRING OVER FOR WELL-FORMEDNESS => "{,},(,),[,]"
 * For example, "([]){()}" is well-formed, as is "[()[]|()()|]". However, "{)" and
 * "[()[]{()()" are n°t well-formed,
 */
public class Problem3 {

    public static void main(String[] args) {
        System.out.println(balancedBrackets("[{()}]"));

        System.out.println(balancedBrackets("{("));

    }

    private static boolean balancedBrackets(String str) {

        Deque<Character> brackets = new LinkedList<>();

        Map<Character, Character> mapping = new HashMap<>();
        mapping.put('[',']');
        mapping.put('{','}');
        mapping.put('(',')');

        Set keys = mapping.keySet();
        Set values = new HashSet<>(mapping.values());

        for (int i = 0 ; i < str.length(); i++ ) {
           char next = str.charAt(i);
           if (keys.contains(next)) {
               brackets.addFirst(next);
           }
           else if (values.contains(next)) {
                if (brackets.isEmpty() || !mapping.get(brackets.removeFirst()).equals(next)){
                    return false;
                }
           }
        }
        if (brackets.isEmpty())
            return true;
        else
            return false;
    }
}
package elementsofProgramming.stack;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by avinashkumarmishra on 20/09/21.
 */
public class StackExp {


    public static void main(String[] agrs) {
        Stack<String> myStack = new Stack<>();

        myStack.push("I am at the bottom.");
        myStack.push("I am in the middle.");
        myStack.push("I am at the top.");


        Iterator<String> itr = myStack.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}

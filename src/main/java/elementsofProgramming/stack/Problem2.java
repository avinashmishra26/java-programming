package elementsofProgramming.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 20/09/21.
 */
public class Problem2 {

    public static void main(String[] args) {

        System.out.println(eval("3,4,+,2,*,1,+"));
    }

    private static int eval(String RPNExpression) {
        String[] inputs = RPNExpression.split(",");

        Deque<Integer> integers = new LinkedList<>();

        for (String s : inputs) {

            if (s.length() == 1 && "+-/*".contains(s)) {

                int ele2 = integers.removeFirst();
                int ele1 = integers.removeFirst();

                switch (s) {
                    case "*":
                        ele1 *= ele2;
                        break;
                    case "+":
                        ele1 += ele2;
                        break;
                    case "-":
                        ele1 -= ele2;
                        break;
                    case "/":
                        ele1 /= ele2;
                        break;
                    default:
                        throw new IllegalArgumentException("Illelgal operation "+s);
                }
                integers.addFirst(ele1);

           } else {
                integers.addFirst(Integer.parseInt(s));
            }
        }
        return integers.removeFirst();
    }
}

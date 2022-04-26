package company;

import java.util.Stack;

/**
 * Created by avinash on 11/04/2022.
 * https://leetcode.com/problems/baseball-game/
 */
public class BaseballGame {

    public static void main(String[] args) {
        System.out.print(calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> num = new Stack();

        for(String op : ops) {

            switch(op) {
                case "+" :
                    int ele1 = num.pop();
                    int ele2 = num.peek();
                    num.push(ele1);
                    num.push(ele1+ele2);
                    break;
                case "D" :
                    int prev = 2*num.peek();
                    num.push(prev);
                    break;
                case "C" :
                    num.pop();
                    break;
                default:
                    int n = Integer.parseInt(op);
                    num.push(n);
                    break;
            }
        }

        int sum = 0;
        while(num.size() > 0) {
            sum += num.pop();
        }
        return sum;
    }
}

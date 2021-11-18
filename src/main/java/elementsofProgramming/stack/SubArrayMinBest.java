package elementsofProgramming.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by avinashkumarmishra on 21/10/21.
 */
public class SubArrayMinBest {

    public static void main(String[] args) {

        //int[] n = {2,9,3,8,1,7,12,6,14,4,32,0,7,19,8,12,6};

        int[] n = {2,9,3,8};

        System.out.print(sumSubarrayMins(n));

    }

    static public int sumSubarrayMins(int[] n) {

        int sum = 0;
        int mod = 1;
        int currentStackValue = 0;

        // int[]{value, count}
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < n.length; i++) {
            int currentCount = 1;
            int currentValue = n[i];

            while (!stack.isEmpty() && stack.peek()[0] >= currentValue) {
                int[] popped = stack.pop();
                currentStackValue -= popped[1] * popped[0];
                currentCount += popped[1]; // assign all previous count to current
            }
            stack.push(new int[]{currentValue, currentCount});
            currentStackValue += currentValue * currentCount;
            sum = (sum + currentStackValue);
        }
        return sum;
    }
}

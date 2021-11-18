package elementsofProgramming.stack;

/**
 * Created by avinashkumarmishra on 20/09/21.
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

public class DequeExp {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Deque<Integer> deque = new LinkedList<>();

        for(int i : list) {
            deque.addFirst(i);
        }

        while (!deque.isEmpty()) {
            System.out.print(deque.poll() +"\t");
        }
    }
}

package elementsofProgramming.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by avinashkumarmishra on 20/09/21.
 */
public class Problem1 {

    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(12);
        st.push(15);
        st.push(8);

        System.out.println(st.max());

        st.pop();
        st.pop();
        System.out.println(st.max());

    }

    private static class ElementWithCachedMax {

        public Integer  element;
        public Integer  max;

        public ElementWithCachedMax(Integer  element, Integer  max) {
            this.element = element;
            this.max = max;
        }
    }

    private static class Stack {

        private Deque<ElementWithCachedMax> elementWithCachedMax = new LinkedList<>();

        public boolean empty() {
            return elementWithCachedMax.isEmpty();
        }

        public Integer max() {
            if (empty()) {
                throw new IllegalStateException("max : Stack is empty");
            }
            return elementWithCachedMax.peek().max;
        }

        public Integer pop() {
            if (empty()) {
                throw new IllegalStateException("Pop called : Stack is empty");
            }
            return elementWithCachedMax.removeFirst().element;
        }

        public void push(Integer x) {
            elementWithCachedMax.addFirst(new ElementWithCachedMax(x, Math.max(x,  empty() ? x : max())));
        }

    }

}



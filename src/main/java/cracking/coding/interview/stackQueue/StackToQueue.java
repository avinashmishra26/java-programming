package cracking.coding.interview.stackQueue;

// Implement queue using only variables and stacks as internal data structures

import java.util.Stack;

public class StackToQueue {


    public static void main(String[] args) {

        StackToQueue a = new StackToQueue();
        a.addElement(1);
        a.addElement(2);
        a.addElement(3);

        System.out.print(a.getElement());
        System.out.print(a.getElement());

        a.addElement(4);
        a.addElement(5);

        System.out.print(a.getElement());
        System.out.print(a.getElement());
        System.out.print(a.getElement());

        System.out.print(a.getElement());
    }

    Stack<Integer> stkLast;

    Stack<Integer> stkFront;

    public StackToQueue() {
        this.stkLast = new Stack();
        this.stkFront = new Stack();
    }


    // O(1)
    public void addElement(int data) {

        synchronized(this) {
            stkLast.push(data);
        }
    }


    // O(n)
    public int getElement() {

        if(stkLast.isEmpty() && stkFront.isEmpty()) {
            return -1;
        }


        if(stkFront.isEmpty()) {
            flipElement(stkLast, stkFront);
        }

        return stkFront.pop();

    }

    private void flipElement(Stack<Integer> stkLast, Stack<Integer> stkFront) {

        synchronized(this) {
            while(!stkLast.isEmpty()) {
                stkFront.push(stkLast.pop());
            }
        }
    }
}
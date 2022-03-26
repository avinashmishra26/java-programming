package cracking.coding.interview.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by avinashkumarmishra on 09/02/22.
 *
 * GenericTreeConstruction with Euler path
 *
 */

public class GenericTreeConstruction {


    public static void main(String[] args) {


        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = constructTree(arr);

        display(root);
    }

    public static GenericTree constructTree(int[] eulerArray) {
        Stack<GenericTree> stack = new Stack<>();
        GenericTree root = null;

        for(int d: eulerArray) {
            if (d != -1) {
                GenericTree node = new GenericTree(d);
                if(stack.isEmpty()) {
                    root = node;
                } else {
                    GenericTree parentNode = stack.peek();
                    parentNode.children.add(node);
                }
                stack.add(node);
            } else {
                stack.pop();
            }
        }
        return root;
    }

    public static void display(GenericTree node) {

        if(node == null) return;

        System.out.print(node.data +" -> ");
        for(GenericTree ch : node.children) {
            System.out.print(ch.data +" , ");
        }
        System.out.println(".");
        for(GenericTree ch : node.children) {
            display(ch);
        }
    }


}

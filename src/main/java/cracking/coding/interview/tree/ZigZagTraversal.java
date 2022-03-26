package cracking.coding.interview.tree;

import java.util.Stack;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *
 **/


public class ZigZagTraversal {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        printZigZagTraversal(root);

    }


    private static void printZigZagTraversal (GenericTree node) {
        Stack<GenericTree> ms = new Stack<>();
        ms.push(node);

        Stack<GenericTree> cs = new Stack<>();

        int level = 1;

        while(!ms.isEmpty()) {
            GenericTree cNode = ms.pop();
            System.out.print(cNode.data + "   ");

            if(level % 2 == 1) {
                for(int i = 0; i < cNode.children.size() ; i++) {
                    cs.push(cNode.children.get(i));
                }
            } else {
                for(int i = cNode.children.size()-1; i >=0  ; i--) {
                    cs.push(cNode.children.get(i));
                }
            }

            if(ms.isEmpty()) {
                ms = cs;
                level++;
                cs = new Stack<>();
                System.out.println();
            }
        }


    }
}
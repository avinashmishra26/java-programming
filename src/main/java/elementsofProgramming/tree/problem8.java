package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 08/11/21.
 */
public class problem8 {

    public static void main(String[] args) {
        ArrayList[] orders = preOrderPostorderWithoutRecursion(PopulateTreeData.populateBST());

        System.out.println("preOrder");
        orders[0].forEach(e -> System.out.print(e + " "));
        System.out.println("\npostOrder");
        orders[1].forEach(e -> System.out.print(e + " "));
    }

    private static class Pair {
        BinaryTreeNode<Integer> node;
        int visit;

        Pair(BinaryTreeNode<Integer> n, int v) {
            visit = v;
            node = n;
        }
    }

    public static ArrayList[] preOrderPostorderWithoutRecursion(BinaryTreeNode<Integer> node) {

        ArrayList<Integer> preOrder = new ArrayList<>();
        ArrayList<Integer> postOrder = new ArrayList<>();

        Deque<Pair> stck = new LinkedList<>();
        stck.addFirst(new Pair(node, 0));

        while(!stck.isEmpty()) {

            Pair topElement = stck.peekFirst();
            if(topElement.visit == 0) {
                preOrder.add(topElement.node.data);
                topElement.visit++;
                if(topElement.node.left != null) {
                    stck.addFirst(new Pair(topElement.node.left, 0));
                }
            }else if(topElement.visit == 1) {
                topElement.visit++;
                if(topElement.node.right != null) {
                    stck.addFirst(new Pair(topElement.node.right, 0));
                }
            }else if(topElement.visit == 2) {
                postOrder.add(topElement.node.data);
                stck.removeFirst();
            }
        }

        return new ArrayList[]{preOrder, postOrder};
    }
}

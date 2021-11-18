package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 04/10/21.
 * COMPUTE THE EXTERIOR OF A BINARY TREE
 */
public class Problem15 {

    public static void main(String[] args) {

        exteriorBinaryTree(PopulateTreeData.populateDataHeightBalanced()).forEach(e -> System.out.print(e.data +" "));

    }

    public static List<BinaryTreeNode<Character>> exteriorBinaryTree(BinaryTreeNode<Character> node) {

        List<BinaryTreeNode<Character>> result = new ArrayList<>();
        result.add(node);
        getLeftExterior(node.left, result);
        result.remove(result.size() - 1);

        getLeaves(node.left, result);
        getLeaves(node.right, result);
        result.remove(result.size() - 1);

        getRightExterior(node.right, result);


        return result;
    }

    private static void getLeftExterior(BinaryTreeNode<Character> node, List<BinaryTreeNode<Character>> result) {

        if(node == null)
            return;

        while (node != null) {
            result.add(node);

            if (node.left != null) {
                node = node.left;
            } else if ( node.right != null) {
                node = node.right;
            } else {
                return;
            }

        }

    }

    private static void getLeaves(BinaryTreeNode<Character> node, List<BinaryTreeNode<Character>> result) {

        if ( node == null) {
            return;
        }
        else if (node.left == null && node.right == null) {
            result.add(node);
        }

        getLeaves(node.left, result);
        getLeaves(node.right, result);
    }


    private static void getRightExterior(BinaryTreeNode<Character> node, List<BinaryTreeNode<Character>> result) {

        if(node == null)
            return;

        while (node != null) {
            result.add(node);

            if (node.right != null) {
                node = node.right;
            } else if ( node.left != null) {
                node = node.left;
            } else {
                return;
            }

        }

    }


}

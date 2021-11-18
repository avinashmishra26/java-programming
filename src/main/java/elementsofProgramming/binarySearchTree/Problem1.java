package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 26/09/21.
 * Test if a binary tree satisfies the BST property
 */
public class Problem1 {

    public static void main(String[] args) {
        System.out.print(isTreeBST(PopulateTreeData.populateBST(), Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private static boolean isTreeBST(BinaryTreeNode<Integer> node, int leftLimit, int rightLimit) {

        if ( node == null)
            return true;

        if ( leftLimit > node.data || node.data > rightLimit)
            return false;

        return isTreeBST(node.left, leftLimit, node.data) && isTreeBST(node.right, node.data, rightLimit);
    }
}

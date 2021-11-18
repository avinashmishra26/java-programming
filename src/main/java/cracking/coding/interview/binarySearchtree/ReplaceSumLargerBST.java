package cracking.coding.interview.binarySearchtree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 13/11/21.
 */
public class ReplaceSumLargerBST {

    static int sum = 0;

    public static void main(String[] args) {

        BinaryTreeNode<Integer> node = PopulateTreeData.populateBST();

        resultBST(node);

        System.out.print(node);
    }

    private static void resultBST( BinaryTreeNode<Integer> node ) {

        if(node == null) return;

        resultBST(node.right);

        int ov = node.data;
        node.data = sum;
        sum += ov;

        resultBST(node.left);

    }
}

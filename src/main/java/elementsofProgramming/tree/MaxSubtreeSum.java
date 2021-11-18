package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 21/10/21.
 */
public class MaxSubtreeSum {

    public static void main(String[] args) {
        MaxSubTreeNode result = new MaxSubTreeNode(null, Integer.MIN_VALUE);
        maxSubtreeSumHelper(PopulateTreeData.populateNodeToRoot(), result);

        System.out.print("Node with value "+result.node.data + " with value "+ result.value);
    }

    private static class MaxSubTreeNode {
        BinaryTreeNode<Integer> node;
        int value;

        MaxSubTreeNode( BinaryTreeNode<Integer> node, int value) {
            this.node = node;
            this.value = value;
        }
    }

    private static MaxSubTreeNode maxSubtreeSumHelper(BinaryTreeNode<Integer> node, MaxSubTreeNode result) {
        if (node == null ){
            return new MaxSubTreeNode(node, 0);
        }

        MaxSubTreeNode left = maxSubtreeSumHelper(node.left, result);
        MaxSubTreeNode right = maxSubtreeSumHelper(node.right, result);

        int total = left.value + right.value + node.data;
        if(total > result.value) {
            result.value = total;
            result.node = node;
        }

        return new MaxSubTreeNode(node, total);
    }

}

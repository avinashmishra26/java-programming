package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 27/10/21.
 * SUM THE ROOT-TO-LEAF PATHS IN A BINARY TREE
 *
 * You are given the root of a binary tree where each node has a value 0 or 1.  Each root-to-leaf path represents a binary number
 * starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then this could represent 01101 in binary, which is 13.

 *  For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

 * Return the sum of these numbers. The answer is guaranteed to fit in a 32-bits integer.
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
public class Problem5 {


    public static void main(String[] args) {

        BinaryTreeNode<Integer> root = PopulateTreeData.populateBinarySum();
        int[] res = new int[1];

        getBinarySum(root, 0, res);
        System.out.print(res[0]);

    }

    private static void getBinarySum(BinaryTreeNode<Integer> node, int prev, int[] res) {


        int newprev = 2*prev + node.data;

        if(node.left == null && node.right == null) {
            res[0] += newprev;
            return;
        }

        if ( node.left != null)
            getBinarySum(node.left, newprev, res);

        if ( node.right != null)
            getBinarySum(node.right, newprev, res);


    }
}

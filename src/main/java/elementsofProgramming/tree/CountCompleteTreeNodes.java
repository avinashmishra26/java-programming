package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 24/10/21.
 */
public class CountCompleteTreeNodes {

    public static void main(String[] args) {
        System.out.print(countNodes(PopulateTreeData.populateNodeToRoot()));
    }

    //Count Number of nodes in Binary Tree not necessarily for Complete Tree

    public static int countNodes(BinaryTreeNode root) {
        if (root == null)
            return 0;
        else if( root.left == null && root.right == null) {
            return 1;
        }

        int left = countNodes(root.left);

        int right = countNodes(root.right);

        return left+right+1;
    }
}

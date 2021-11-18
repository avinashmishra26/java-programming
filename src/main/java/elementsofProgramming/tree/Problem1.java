package elementsofProgramming.tree;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class Problem1 {

    public static void main(String[] args) {
        BalancedStatusWithHeight statusWithHeight = isBalanced(PopulateTreeData.populateDataHeightBalanced());

        System.out.print(statusWithHeight.balanced + " : Node at :"+ (char)statusWithHeight.nodeValue + " : with height :"+statusWithHeight.height);
    }

    private static class BalancedStatusWithHeight {

        public boolean balanced;
        public int height;
        public int nodeValue;

        public BalancedStatusWithHeight(boolean balanced, int height,int nodeValue) {
            this.balanced = balanced;
            this.height = height;
            this.nodeValue = nodeValue;
        }
    }


    public static BalancedStatusWithHeight isBalanced(BinaryTreeNode<Character> node) {
        return checkBalanced(node);
    }

    public static BalancedStatusWithHeight checkBalanced(BinaryTreeNode<Character> node) {

        if (node == null) {
            return new BalancedStatusWithHeight(true, -1, 0);
        }

        BalancedStatusWithHeight leftHeight = checkBalanced(node.left);
        if (!leftHeight.balanced){
            return leftHeight;
        }

        BalancedStatusWithHeight rightHeight = checkBalanced(node.right);
        if (!rightHeight.balanced){
            return rightHeight;
        }

        boolean isBalanced = Math.abs(leftHeight.height - rightHeight.height) <= 1 ;
        int height = Math.max(leftHeight.height, rightHeight.height) + 1;

        return new BalancedStatusWithHeight(isBalanced, height, node.data);

    }



}



package elementsofProgramming.binarySearchTree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

/**
 * Created by avinashkumarmishra on 27/04/22.
 */
public class Problem1_UsingAnotherWay {

    public static void main(String[] args) {
        System.out.print(isBST(PopulateTreeData.populateBST()).isRuleFollowed);
    }


    private static Range isBST(BinaryTreeNode<Integer> node) {

        Range l;
        if(node.left == null) {
            l = new Range(node.data, node.data, true);
        } else {
            l = isBST(node.left);
        }


        Range r;
        if(node.right == null) {
            r = new Range(node.data, node.data, true);
        } else {
            r = isBST(node.right);
        }

        if ( l.isRuleFollowed == false || r.isRuleFollowed == false) {
            return new Range(0, 0, false);
        } else if (l.max <= node.data && r.min >= node.data) {
            return new Range(l.min, r.max, true);
        } else {
            return new Range(0, 0, false);
        }

    }

    private static class Range {

        int min;
        int max;
        boolean isRuleFollowed;

        Range(int min, int max, boolean isRuleFollowed){
            this.min = min;
            this.max = max;
            this.isRuleFollowed = isRuleFollowed;
        }

    }
}

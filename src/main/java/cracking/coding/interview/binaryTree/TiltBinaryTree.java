package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 17/04/2022.
 *
 * https://leetcode.com/problems/binary-tree-tilt/
 */
public class TiltBinaryTree {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});


        TiltValue tilt = new TiltValue();

        subTreeSum(t, tilt);

        System.out.print(tilt.val);
    }


    private static int subTreeSum(TreeNode node, TiltValue totalTilt) {

        if(node == null) return  0;

        int left = subTreeSum(node.left, totalTilt);

        int right = subTreeSum(node.right, totalTilt);

        totalTilt.val += Math.abs(left-right);

        return left+right+node.data;
    }


    private static class TiltValue {
        int val;

        TiltValue() {
            this.val = 0;
        }
    }
}

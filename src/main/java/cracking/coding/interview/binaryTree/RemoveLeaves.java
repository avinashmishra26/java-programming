package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 17/04/2022.
 */
public class RemoveLeaves {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        t = removeLeaves(t);

        Traversal.preOrder(t);
    }


    private static TreeNode removeLeaves(TreeNode node) {
        if(node == null || (node.left == null && node.right == null)) {
            return null;
        }

        node.left = removeLeaves(node.left);

        node.right = removeLeaves(node.right);

        return node;

    }
}

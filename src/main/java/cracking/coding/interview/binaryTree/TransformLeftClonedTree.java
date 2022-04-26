package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 17/04/2022.
 */
public class TransformLeftClonedTree {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        cloneLeftTree(t);

        Traversal.preOrder(t);

        System.out.println("\nRemoving clone");
        removeClone(t);

        Traversal.preOrder(t);
    }

    private static void cloneLeftTree(TreeNode node) {
        if(node == null)  return;


        TreeNode copy = new TreeNode(node.data, node.left, null);
        node.left = copy;
        cloneLeftTree(copy.left);

        cloneLeftTree(node.right);

    }

    private static TreeNode removeClone(TreeNode node) {
        if(node == null)  return null;

        TreeNode left = removeClone(node.left.left);

        TreeNode right = removeClone(node.right);

        node.left = left;
        //node.right = right;
        return node;
    }
}

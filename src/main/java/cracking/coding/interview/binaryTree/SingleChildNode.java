package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 17/04/2022.
 */
public class SingleChildNode {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null});

        printSingleChild(t);
    }

    private static void printSingleChild(TreeNode node) {
        if(node == null) return;

        if(node.left != null && node.right == null ) {
            System.out.print(node.left.data + "  ");
        } else if(node.left == null && node.right != null) {
            System.out.print(node.right.data + "  ");
        }

        printSingleChild(node.left);
        printSingleChild(node.right);
    }
}

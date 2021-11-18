package util;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class Traversal {

    static void inOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            inOrderTraversal(node.left);
            visit(node);
            inOrderTraversal(node.right);
        }
    }

    static void preOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.left);
            preOrderTraversal(node.right);
        }
    }

    static void postOrderTraversal(BinaryTreeNode node) {
        if (node != null) {
            postOrderTraversal(node.left);
            postOrderTraversal(node.right);
            visit(node);
        }
    }


    static void visit(BinaryTreeNode node) {
        System.out.print(node.data);
    }
}

package cracking.coding.interview.binaryTree;

import java.util.ArrayDeque;

/**
 * Created by avinash on 15/04/2022.
 */
public class LevelOrderTraversal {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});


        levelOrder(t);

    }
    private static void levelOrder(TreeNode node) {

        ArrayDeque<TreeNode> stk = new ArrayDeque<>();
        stk.add(node);

        while(stk.size() > 0) {
            int children = stk.size();

            for(int i = 1; i <= children; i++) {
                TreeNode t = stk.remove();
                if(t.left != null) {
                    stk.add(t.left);
                }
                if(t.right != null) {
                    stk.add(t.right);
                }
                System.out.print(t.data + " ");
            }
            System.out.println();
        }
    }
}

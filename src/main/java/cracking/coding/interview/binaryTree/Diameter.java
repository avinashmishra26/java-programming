package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 17/04/2022.
 */
public class Diameter {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        int[] diameter = new int[1];

        getHeight(t, diameter);

        System.out.print(diameter[0]);
    }


    private static int getHeight(TreeNode node, int[] diameter) {

        if(node == null) return -1;

        int l = 1 + getHeight(node.left, diameter);

        int r = 1 + getHeight(node.right, diameter);

        if( (l+r) > diameter[0]) {
            diameter[0] = l+r;
        }

        return Math.max(l, r);

    }
}

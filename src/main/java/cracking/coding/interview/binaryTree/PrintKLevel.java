package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 16/04/2022.
 */
public class PrintKLevel {


    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        printKLevel(t, 2, 0);
    }

    private static void printKLevel(TreeNode node , int kLevel, int levelSoFar) {

        if(node == null || kLevel < 0) return;

        if(kLevel == levelSoFar) {
            System.out.print(node.data + " ");
            return;
        }


        printKLevel(node.left, kLevel, levelSoFar+1);
        printKLevel(node.right, kLevel, levelSoFar+1);
    }
}

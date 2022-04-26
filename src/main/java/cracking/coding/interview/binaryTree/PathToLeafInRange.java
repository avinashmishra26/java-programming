package cracking.coding.interview.binaryTree;

/**
 * Created by avinash on 16/04/2022.
 */
public class PathToLeafInRange {

    public static void main(String[] args) {

        TreeNode t = ConstructBinaryTree.constructBT(new Integer[]{50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null});

        printInRange(t, 0, 1000,0, "");
    }

    private static void printInRange(TreeNode node, int low, int high, int sumSoFar, String pathSoFar) {

        if(node == null) return;

        if(node.left == null && node.right == null) {
            sumSoFar += node.data;
            pathSoFar += node.data;
            if(sumSoFar > low && sumSoFar < high) {
                System.out.print(sumSoFar+ " :");
                System.out.println("pathSoFar" +pathSoFar);
            }
            return;
        }

        printInRange(node.left, low, high, sumSoFar + node.data, pathSoFar+node.data+" ");
        printInRange(node.right, low, high, sumSoFar + node.data,  pathSoFar+node.data+" ");
    }
}

package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinashkumarmishra on 19/10/21.
 */
public class PrintNodesAtKDistance {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = PopulateTreeData.populateNodeToRoot();
        List<BinaryTreeNode<Integer>> path = new ArrayList<>();

        NodeToRootPath.findNodeToRootPath(root, 401, path);

        int distance = 6;
        int initialDistance=1;
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < path.size(); i++) {
            if( i == 0 ){
                findKDistanceNodes(path.get(i).left , initialDistance, distance, result);
                findKDistanceNodes(path.get(i).right , initialDistance, distance, result);
            } else {
                if ((initialDistance-1) > distance) {
                    break;
                }
                if ((initialDistance-1) == distance) {
                    result.add(path.get(i).data);
                }
                else if(path.get(i).left == path.get(i-1) ) {
                    findKDistanceNodes(path.get(i).right , initialDistance, distance, result);
                } else {
                    findKDistanceNodes(path.get(i).left , initialDistance, distance, result);
                }
            }

            initialDistance++;
        }

        display(result);

    }

    private static void display(List<Integer> path) {
        for (int node : path) {
            System.out.print(node +" - ");
        }
    }

    private static void findKDistanceNodes(BinaryTreeNode<Integer> node, int initialDistance, int finalDistance, List<Integer> result) {

        if(node == null)
            return;

        if (initialDistance == finalDistance) {
            result.add(node.data);
            return;
        }

        findKDistanceNodes(node.left, initialDistance+1, finalDistance, result);
        findKDistanceNodes(node.right, initialDistance+1, finalDistance, result);

    }

}

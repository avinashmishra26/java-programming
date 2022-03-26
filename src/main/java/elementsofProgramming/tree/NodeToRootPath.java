package elementsofProgramming.tree;

import util.BinaryTreeNode;
import util.PopulateTreeData;

import java.util.ArrayList;
import java.util.List;

/**
 *  Created by avinashkumarmishra on 19/10/21.
 *  Target Node To Root Path
 *  2022
 *
 */
public class NodeToRootPath {

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = PopulateTreeData.populateNodeToRoot();
        List<BinaryTreeNode<Integer>> path = new ArrayList<>();

        findNodeToRootPath(root, 401, path);
        display(path);

    }

    private static void display(List<BinaryTreeNode<Integer>> path) {
        for (BinaryTreeNode node : path) {
            System.out.print(node.data +" - ");
        }
    }

    static boolean findNodeToRootPath(BinaryTreeNode<Integer> node, int targetValue, List<BinaryTreeNode<Integer>> path) {

        if(node == null) {
            return false;
        }
        else if(node.data == targetValue) {
            path.add(node);
            return true;
        }

        boolean pathFound = false;
        pathFound = findNodeToRootPath(node.right, targetValue, path);
        if(pathFound) {
            path.add(node);
            return true;
        }

        pathFound = findNodeToRootPath(node.left, targetValue, path);
        if(pathFound) {
            path.add(node);
            return true;
        }

        return false;
    }
}



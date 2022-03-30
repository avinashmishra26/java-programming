package cracking.coding.interview.tree;

import java.util.ArrayList;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  NodeToRootPath in a tree
 *
 **/


public class NodeToRootPath {


    public static void main(String[] args) {

        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        ArrayList<Integer> result = new ArrayList<>();
        nodeToRootPath(root, 120, result);


        for(int i = result.size()-1; i>=0; i--)
            System.out.print(result.get(i) + "  -> ");

    }
    public static void nodeToRootPath(GenericTree node, int ele, ArrayList<Integer> result) {

        if(node.data == ele) {
            result.add(node.data);
            return;
        }

        for(int i = 0 ; i < node.children.size(); i++) {
            nodeToRootPath(node.children.get(i), ele, result);
            if(result.size() > 0) {
                result.add(node.data);
                return;
            }
        }

    }
}
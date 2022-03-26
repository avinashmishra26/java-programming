package cracking.coding.interview.tree;

import java.util.ArrayList;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 * RemoveLeaves of a Generic Tree
 *
 */

public class RemoveLeaves {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        GenericTreeConstruction.display(removeLeaves(root));

        System.out.println();

        root = GenericTreeConstruction.constructTree(arr);
        removeLeavesMethod2(root);
        GenericTreeConstruction.display(root);


    }

    private static GenericTree removeLeaves(GenericTree node) {
        if(node.children.size() == 0) return null;


        GenericTree gt = new GenericTree(node.data);

        for(int i = 0; i < node.children.size() ; i++) {
            GenericTree  n_node = removeLeaves(node.children.get(i));
            if(n_node != null)
                gt.children.add(n_node);
        }


        return gt;
    }

    //one - more method : Better becauase using less space
    private static void removeLeavesMethod2(GenericTree node) {

        for(int i = node.children.size()-1; i >=0 ; i--) {
            GenericTree child = node.children.get(i);
            if(child.children.size() == 0) {
                node.children.remove(child);
            }
        }

        for(GenericTree child : node.children) {
            removeLeavesMethod2(child);
        }
    }

}
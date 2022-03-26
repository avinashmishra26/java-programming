package cracking.coding.interview.tree;

import java.util.ArrayList;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 * Mirror of a Generic Tree
 *
 */

public class MirrorBuild {


    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        GenericTreeConstruction.display(createMirror(root));


    }

    private static GenericTree createMirror(GenericTree node) {
        if(node.children.size() == 0) return node;


        GenericTree newChildred = new GenericTree(node.data);
        ArrayList<GenericTree> c = new ArrayList<>();
        newChildred.children = c;

        for(int i = node.children.size()-1; i >= 0; i--) {
            GenericTree cmode = createMirror(node.children.get(i));
            newChildred.children.add(cmode);
        }
        return newChildred;
    }

}
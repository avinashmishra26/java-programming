package cracking.coding.interview.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by avinashkumarmishra on 12/03/22.
 */

public class LevelOrderTraversal {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        levelOrderTraversal(root);

        level2(root);

    }

    static private void levelOrderTraversal(GenericTree node) {
        ArrayDeque<GenericTree> level = new ArrayDeque<>();
        level.add(node);

        while(level.size() > 0) {
            int size = level.size();

            for (int i = 0; i < size; i++) {
                GenericTree t = level.remove() ;
                System.out.print(t.data + " ");

                for(GenericTree g : t.children) {
                    level.add(g);
                }
            }
            System.out.println();
        }
    }

    static private void level2(GenericTree node) {

        Queue<GenericTree> parent = new ArrayDeque<>();
        parent.add(node);

        Queue<GenericTree> child = null;

        while(parent.size() > 0) {
            child = new ArrayDeque<>();
            while (parent.size() > 0) {
                GenericTree n = parent.remove();

                System.out.print(n.data + " ");
                for (GenericTree c : n.children) {
                    child.add(c);
                }
            }
            System.out.println();
            parent = child;
        }

    }
}
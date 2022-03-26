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

        System.out.println("1st approach");
        levelOrderTraversal(root);

        System.out.println("\n2rd approach");
        level2(root);

        System.out.println("\n3rd approach");
        //one more way
        levelOrder(root);

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

    // with 2 Queues
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

    //one more way
    private static void levelOrder(GenericTree node) {

        GenericTree marker = new GenericTree(-1);

        ArrayDeque<GenericTree> mq = new ArrayDeque<>();
        mq.add(node);
        mq.add(marker);


        while(!mq.isEmpty()) {

            GenericTree g = mq.poll();
            if(g.data != -1) {
                System.out.print(g.data + " ");
                for(int i = 0; i <g.children.size(); i++) {
                    mq.add(g.children.get(i));
                }
            } else {
                if(mq.size() > 0) {
                    System.out.println();
                    mq.add(marker);
                }
            }

        }

    }
}
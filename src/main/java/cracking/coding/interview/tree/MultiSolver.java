package cracking.coding.interview.tree;

/**
 * Created by avinashkumarmishra on 26/03/22.
 *
 *  MultiSolver
 *
**/


public class MultiSolver {



    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        multiSolver(root, 0);

        System.out.println("size "+size);

        System.out.println("min "+min);

        System.out.println("max "+max);

        System.out.println("height "+height);

    }

    static int size = 0;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int height = 0;

    private static void multiSolver(GenericTree node, int depth) {

        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(depth, height);

        for(int i = 0; i < node.children.size(); i++) {
            multiSolver(node.children.get(i), depth+1);
        }


    }
}
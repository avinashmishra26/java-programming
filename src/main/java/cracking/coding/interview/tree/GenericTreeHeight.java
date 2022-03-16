package cracking.coding.interview.tree;

public class GenericTreeHeight {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        System.out.print(height(root));

    }

    private static int height(GenericTree node) {

        int height = 0;

        for(GenericTree g : node.children) {
            int h1 = height(g);
            height = Math.max(h1, height);
        }
        return 1+height;
    }
}
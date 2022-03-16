package cracking.coding.interview.tree;

public class GenericTreeSize {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        System.out.print(size(root));
    }

    public static int size(GenericTree node) {

        int totalSize = 0;

        for(GenericTree n1 : node.children) {
            totalSize += size(n1);

        }
        return 1 + totalSize;
    }

}
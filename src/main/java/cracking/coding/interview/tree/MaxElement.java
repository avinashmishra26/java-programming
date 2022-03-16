package cracking.coding.interview.tree;

public class MaxElement {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        maxNode(root, max);
        System.out.println(max[0]);

        System.out.print(maxNodeRecurrsive(root));
    }

    private static void maxNode(GenericTree node, int[] max) {
        if(node.data > max[0]) {
            max[0] = node.data;
        }
        for(GenericTree ch : node.children) {
            maxNode(ch, max);
        }
    }

    private static int maxNodeRecurrsive(GenericTree node) {
        int max = Integer.MIN_VALUE;

        for(GenericTree g : node.children) {
            int maxC = maxNodeRecurrsive(g);
            max = Math.max(maxC, max);
        }
        max = Math.max(node.data, max);
        return max;
    }
}
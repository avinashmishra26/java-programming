package cracking.coding.interview.tree;

public class GenericTreeTravesal {

    public static void main(String[] args) {
        int[] arr = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        GenericTree root = GenericTreeConstruction.constructTree(arr);

        travesals(root);


    }

    private static void travesals(GenericTree node) {

        System.out.println("Node Pre "+node.data);

        for(GenericTree child: node.children) {
            System.out.println("Edge Pre "+node.data + "--"+ child.data);
            travesals(child);
            System.out.println("Edge Post "+node.data + "--"+ child.data);
        }

        System.out.println("Node Post "+node.data);
    }
}
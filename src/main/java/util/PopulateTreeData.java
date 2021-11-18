package util;

/**
 * Created by avinashkumarmishra on 14/09/21.
 */
public class PopulateTreeData {

    public static BinaryTreeNode<Character> populateDataHeightBalanced() {
        BinaryTreeNode<Character> root = new BinaryTreeNode<Character>();
        root.data = 'A';

        root.left = new BinaryTreeNode<Character>();
        root.left.data = 'B';

        root.left.left = new BinaryTreeNode<Character>();
        root.left.left.data = 'C';

        root.left.left.left = new BinaryTreeNode<Character>();
        root.left.left.left.data = 'D';

        root.left.left.right = new BinaryTreeNode<Character>();
        root.left.left.right.data = 'G';

        root.left.left.left.left = new BinaryTreeNode<Character>();
        root.left.left.left.left.data = 'E';

        root.left.left.left.right = new BinaryTreeNode<Character>();
        root.left.left.left.right.data = 'F';

        root.left.right = new BinaryTreeNode<Character>();
        root.left.right.data = 'H';

        root.left.right.left = new BinaryTreeNode<Character>();
        root.left.right.left.data = 'I';

        root.left.right.right = new BinaryTreeNode<Character>();
        root.left.right.right.data = 'J';

        root.right = new BinaryTreeNode<Character>();
        root.right.data = 'K';

        root.right.left = new BinaryTreeNode<Character>();
        root.right.left.data = 'L';

        root.right.left.left = new BinaryTreeNode<Character>();
        root.right.left.left.data = 'M';

        root.right.left.right = new BinaryTreeNode<Character>();
        root.right.left.right.data = 'N';

        root.right.right = new BinaryTreeNode<Character>();
        root.right.right.data = 'O';

        return root;
    }


    public static BinaryTreeNode<Integer> populateForSymmetric() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 314;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 6;

        root.left.right = new BinaryTreeNode<Integer>();
        root.left.right.data = 2;

        root.left.right.right = new BinaryTreeNode<Integer>();
        root.left.right.right.data = 3;


        root.right = new BinaryTreeNode<Integer>();
        root.right.data = 6;

        root.right.left = new BinaryTreeNode<Integer>();
        root.right.left.data = 2;

        //root.right.right = new BinaryTreeNode<Integer>();
        //root.right.right.data = 2;

        root.right.left.left = new BinaryTreeNode<Integer>();
        root.right.left.left.data = 3;

        return root;
    }


    public static BinaryTreeNode<Integer> populateBST() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 50;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 25;

        root.left.left = new BinaryTreeNode<Integer>();
        root.left.left.data = 15;

        root.left.right = new BinaryTreeNode<Integer>();
        root.left.right.data = 29;



        root.right = new BinaryTreeNode<Integer>();
        root.right.data = 75;

        root.right.left = new BinaryTreeNode<Integer>();
        root.right.left.data = 60;


        root.right.right = new BinaryTreeNode<Integer>();
        root.right.right.data = 100;

        return root;
    }


    public static BinaryTreeNode<Integer> populateForLevelOrder() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 3;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 9;


        root.right = new BinaryTreeNode<Integer>();
        root.right.data = 20;

        root.right.left = new BinaryTreeNode<Integer>();
        root.right.left.data = 15;

        root.right.right = new BinaryTreeNode<Integer>();
        root.right.right.data = 7;

        return root;
    }

    public static BinaryTreeNode<Integer> populatePathSum() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 5;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 4;

        root.left.left = new BinaryTreeNode<Integer>();
        root.left.left.data = 11;

        root.left.left.left = new BinaryTreeNode<Integer>();
        root.left.left.left.data = 7;

        root.left.left.right = new BinaryTreeNode<Integer>();
        root.left.left.right.data = 2;



        root.right = new BinaryTreeNode<Integer>();
        root.right.data = 8;

        root.right.left = new BinaryTreeNode<Integer>();
        root.right.left.data = 13;

        root.right.right = new BinaryTreeNode<Integer>();
        root.right.right.data = 4;

        root.right.right.left = new BinaryTreeNode<Integer>();
        root.right.right.left.data = 5;

        root.right.right.right = new BinaryTreeNode<Integer>();
        root.right.right.right.data = 1;



        return root;
    }



    public static BinaryTreeNode<Integer> populateNodeToRoot() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 314;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 6;

        root.left.left = new BinaryTreeNode<Integer>();
        root.left.left.data = 271;

        root.left.left.left = new BinaryTreeNode<>();
        root.left.left.left.data = 28;

        root.left.left.right = new BinaryTreeNode<>();
        root.left.left.right.data = 0;

        root.left.right = new BinaryTreeNode<>();
        root.left.right.data = 561;

        root.left.right.right = new BinaryTreeNode<>();
        root.left.right.right.data = 3;


        root.left.right.right.left = new BinaryTreeNode<>();
        root.left.right.right.left.data = 17;

        root.right = new BinaryTreeNode<>();
        root.right.data = 6;

        root.right.left = new BinaryTreeNode<>();
        root.right.left.data = 2;

        root.right.left.right = new BinaryTreeNode<>();
        root.right.left.right.data = 1;

        root.right.left.right.left = new BinaryTreeNode<>();
        root.right.left.right.left.data = 401;

        root.right.left.right.right = new BinaryTreeNode<>();
        root.right.left.right.right.data = 257;

        root.right.left.right.left.right = new BinaryTreeNode<>();
        root.right.left.right.left.right.data = 641;

        root.right.right = new BinaryTreeNode<>();
        root.right.right.data = 271;

        root.right.right.right = new BinaryTreeNode<>();
        root.right.right.right.data = 28;

        return root;
    }


    public static BinaryTreeNode<Integer> populateBinarySum() {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>();
        root.data = 1;

        root.left = new BinaryTreeNode<Integer>();
        root.left.data = 0;

        root.left.left = new BinaryTreeNode<Integer>();
        root.left.left.data = 0;

        root.left.right = new BinaryTreeNode<Integer>();
        root.left.right.data = 1;

        root.right = new BinaryTreeNode<Integer>();
        root.right.data = 1;

        root.right.left = new BinaryTreeNode<Integer>();
        root.right.left.data = 0;

        root.right.right = new BinaryTreeNode<Integer>();
        root.right.right.data = 1;

        return root;
    }
}

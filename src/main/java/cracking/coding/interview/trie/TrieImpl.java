package cracking.coding.interview.trie;

/**
 * Created by avinashkumarmishra on 09/10/21.
 */
public class TrieImpl {

    private final static int ALPHABET_SIZE = 26;

    private static class TrieNode {
        boolean isLeaf = false;
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
    }

    public static void main(String[] args) {

        TrieNode startNode = new TrieNode();

        insert(startNode, "Many");
        insert(startNode, "Ma");
        insert(startNode, "avi");

        System.out.println("H");

        System.out.println(search(startNode, "many"));

        System.out.println(search(startNode, "man"));
    }

    private static boolean search(TrieNode startNode, String str) {
        str = str.toLowerCase();

        for(int i = 0; i < str.length() ; i++) {
            int c = getIndex(str.charAt(i));
            if ( startNode.children[c] == null){
                return false;
            }
            startNode = startNode.children[c];
        }
        return startNode.isLeaf;
    }

    private static void insert(TrieNode startNode, String str) {

        str = str.toLowerCase();

        for(int i = 0; i < str.length() ; i++) {
            int c = getIndex(str.charAt(i));
            if ( startNode.children[c] == null){
                startNode.children[c] = new TrieNode();
            }
            startNode = startNode.children[c];
        }
        startNode.isLeaf = true;
    }

    private static int getIndex(char c) {
        if (c < 'a' || c > 'z' ) {
            throw new IllegalArgumentException("Wrong characters");
        }
        return c - 'a';
    }
}



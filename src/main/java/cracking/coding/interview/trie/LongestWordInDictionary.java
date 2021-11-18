package cracking.coding.interview.trie;

import java.util.Arrays;

/**
 * Created by avinashkumarmishra on 24/10/21.
 */
public class LongestWordInDictionary {

    public static void main(String[] args) {
        System.out.print(longestWord(new String[]{"w","wo","wor","worl","world"}));
    }

    public static String longestWord(String[] words) {
        Arrays.sort(words);

        TargetWord r = new TargetWord();

        TrieNode trie = new TrieNode();
        trie.hashValue = 1;
        trie.depth = 0;
        trie.leafNode = true;

        for(String word: words) {

            TrieNode temp = trie;
            int hashVal = trie.hashValue;
            int depth = trie.depth;

            for(int i = 0; i< word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if(temp.child[idx] == null) {
                    temp.child[idx] = new TrieNode();

                    if(hashVal != 0 && temp.leafNode) {
                        hashVal = 31*hashVal + idx;
                        depth++;
                    } else {
                        hashVal = 0;
                        depth = 0;
                    }

                } else {
                    if(temp.child[idx].leafNode) {
                        hashVal = temp.child[idx].hashValue;
                        depth = temp.child[idx].depth;
                    } else {
                        hashVal = 0;
                        depth = 0;
                    }
                }
                temp = temp.child[idx];

            }
            temp.leafNode = true;
            temp.hashValue = hashVal;
            temp.depth = depth;

            if(r.depth < depth) {
                r.depth = depth;
                r.hashValue = hashVal;
                r.word = word;
            }
        }
        return r.word;
    }

    private static class TargetWord {
        String word = "";
        int depth = 0;
        int hashValue = 0;
    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean leafNode;
        int depth = 0;
        int hashValue = 0;
    }
}

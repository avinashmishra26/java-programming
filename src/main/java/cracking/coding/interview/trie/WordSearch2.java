package cracking.coding.interview.trie;

import java.util.*;

/**
 * Created by avinashkumarmishra on 24/10/21.
 * https://leetcode.com/problems/word-search-ii/
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells
 * are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 */
public class WordSearch2 {

    static int cnt = 0;

    public static void main(String[] args) {
        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        findWords(board, new String[]{"oa","oaa"}).forEach(e -> System.out.print(e + " "));

        System.out.println("\nwithout optimized " +cnt); //without optimized 26
    }

    public static List<String> findWords(char[][] board, String[] words) {

        TrieNode trie = new TrieNode();

        for(String word: words) {
            TrieNode temp = trie;
            for(int i = 0; i< word.length(); i++) {
                int ch = word.charAt(i) - 'a';
                if(temp.child[ch] == null){
                    temp.child[ch] = new TrieNode();
                }

                temp = temp.child[ch];
            }
            temp.leafNode = true;
            temp.res = word;
        }
        Set<String> res = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j< board[0].length; j++) {
                findWordsInTrie(trie, board,  res, visited, i, j);
            }
        }
        return new ArrayList<String>(res);

    }

    private static class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean leafNode;
        String res = null;
    }

    private static void findWordsInTrie(TrieNode trie, char[][] board, Set<String> res, boolean[][] visited, int i, int j) {

        cnt++;

        int c = board[i][j] - 'a';
        if(trie.child[c] == null) {
            return;
        }
        if(trie.child[c].leafNode){
            res.add(trie.child[c].res);
        }
        visited[i][j] = true;
        trie = trie.child[c];

        int[][] shifts = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int[] s: shifts) {
            int next_i = i+s[0];
            int next_j = j+s[1];
            if( next_i >= 0 && next_j >= 0 && next_i < board.length && next_j < board[0].length && !visited[next_i][next_j]) {
                findWordsInTrie(trie, board,  res, visited, next_i, next_j);
            }
        }
        visited[i][j] = false;

    }
}

package elementsofProgramming.graph;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by avinashkumarmishra on 09/10/21.
 */
public class LeetCodeHard {

    public static void main(String[] args) {

        findWords(null, null);
    }

    public static List<String> findWords(char[][] board, String[] words) {
        Set<String> wordsMap = new HashSet<>();
        for (String s : words)
            wordsMap.add(s);

        char[][] colorBoard = new char[board.length][];
        for ( int i =0 ; i< board.length; i++) {
            char[] columns = new char[board[i].length];
            for( int j = 0; j< columns.length; j++){
                columns[j] = 'W';
            }
            colorBoard[i] = columns;
        }
        return findWords(board, wordsMap, colorBoard);
    }

    private static enum color {W, B};

    public static List<String> findWords(char[][] board , Set<String> words, char[][] colorBoard) {

        int[][] shifts = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        return null;

    }
}

package blindQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Window stratergy
 *
 * Longest Substring Without Repeating Characters
 * Leetcode 3
 *
 */

public class Problem3 {

    public static void main(String[] args) {
        System.out.print(getLongestSubString("abcabcbbzrt"));
    }

    private static int getLongestSubString(String s) {

        Set<Character> res = new HashSet<>();
        int maxLength = Integer.MIN_VALUE;

        for(int i = 0, start = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(res.contains(c)) {
                while(s.charAt(start) != c) {
                    res.remove(s.charAt(start));
                    start++;
                }
                res.remove(c);
                start++;

            }

            res.add(c);

            maxLength = Math.max(maxLength, res.size());
        }
        return maxLength;
    }
}
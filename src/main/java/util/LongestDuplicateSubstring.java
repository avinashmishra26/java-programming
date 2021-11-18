package util;

import java.util.*;

/**
 * Created by avinashkumarmishra on 30/10/21.
 *
 *
 */
public class LongestDuplicateSubstring {

    public static void main(String[] args) {
        System.out.print(longestDupSubstring("banana"));
    }

    static final int P = 31, MOD = 100_003;

    // Given a string and a length, returns the start index of a substring that occurs more than once. Returns -1 otherwise.
    static int dupExists(String s, int len) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        int hash = 0, firstLetterCoeff = 1;
        // Calculate hash for the first len chars.
        for (int i = 0; i < len; ++i) {
            hash = hash*P + s.charAt(i) - 'a' + 1;
            hash %= MOD;
        }

        // Compute the coefficient for the leftmost character.
        for (int i = len - 1; i > 0; --i) {
            firstLetterCoeff = (firstLetterCoeff*P) % MOD;
        }

        // Add the hash of the substring that consists of the first 'len' chars to map.
        map.putIfAbsent(hash, new ArrayList<>());
        map.get(hash).add(0);

        for (int end = len; end < s.length(); ++end) {
            // Start index of the substring whose last char is at 'end'.
            int start = end - len + 1;

            // remove first (leftmost) char from hash, which has now gone past the edge of the sliding window.
            hash = hash + MOD - (((s.charAt(start - 1) - 'a' + 1)*firstLetterCoeff) % MOD);
            hash %= MOD;

            // add last char to hash, which has just entered the window.
            hash = hash*P + s.charAt(end) - 'a' + 1;
            hash %= MOD;

            map.putIfAbsent(hash, new ArrayList<>());
            List<Integer> list = map.get(hash);
            list.add(start);

            // Hash collision. Need to compare all candidates naively to see if there is a match.
            if (list.size() > 1) {
                String substr = s.substring(start, end + 1);

                // Last entry is the current substring, so start from list.size() - 2.
                for (int i = list.size() - 2; i >= 0; --i) {
                    if (substr.equals(s.substring(list.get(i), list.get(i) + len)))
                        return start;
                }
            }
        }

        return -1;
    }

    public static String longestDupSubstring(String s) {

        // Min length of a duplicate substring is 1, max is s.length() - 1.
        int left = 1, right = s.length() - 1, resLength = 0, resIndex = -1;

        // Binary search on the substring length.
        while (left <= right) {
            int mid = left + (right - left)/2;
            int idx = dupExists(s, mid);
            if (-1 == idx)
                right = mid - 1;
            else {
                resLength = mid;
                resIndex = idx;
                left = mid + 1;
            }
        }

        return resLength == 0 ? "" : s.substring(resIndex, resIndex + resLength);
    }
}

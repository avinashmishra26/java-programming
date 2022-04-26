package programming.level2;

/**
 * Created by avinash on 21/04/2022.
 *
 * KMP Algo is based on finding longest prefix and suffix for a string
 *
 * Here lets pattern = aab
 * and given_str = aabaabaab
 *
 * We can return first match , we can also return number of matches, here we are
 * evaluating number of matches, by passing  pattern#Given_str
 *
 */
public class KMP_Algorithm {

    public static void main(String[] args) {
        String pattern = "aab";
        String given_str = "aabaabaab";

        int[] lpsValue = getLPS(pattern+"#"+given_str);

        //count how many values in array have values = pattern.length()
        int cnt = 0;
        for(int i = pattern.length()+1; i < lpsValue.length; i++) {
            if(lpsValue[i] == pattern.length()) {
                cnt++;
            }
        }
        System.out.println(cnt);

        System.out.println("evaluating LPS for a string");
        //lps of string "aabaacaabaad"
        lpsValue = getLPS("aabaacaabaad");
        for(int i = 0; i < lpsValue.length; i++) {
            System.out.print("aabaacaabaad".charAt(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < lpsValue.length; i++) {
            System.out.print(lpsValue[i] + " ");
        }
    }

    //derives longest proper prefix and suffix
    private static int[] getLPS(String fullString) {

        int[] lps = new int[fullString.length()];

        int i = 1;
        int len = 0;

        while(i < fullString.length()) {

            if(fullString.charAt(i) == fullString.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }

        }
        return lps;
    }
}

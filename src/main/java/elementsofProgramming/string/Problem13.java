package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 31/10/21.
 * Using Rabin - Karp method
 * The average and best-case running time of the Rabin-Karp algorithm is O(n+m),
 * but its worst-case time is O(nm). Worst case of Rabin-Karp algorithm occurs
 * when all characters of pattern and text are same as the hash values of all
 * the substrings of txt[] match with hash value of pat[]. For example pat[] = “AAA” and txt[] = “AAAAAAA”.
 */
public class Problem13 {

    static final int d = 31;

    /* Driver Code */
    public static void main(String[] args)
    {
        String txt = "ABDCB";
        String pat = "DC";

        // A prime number
        int q = 11;

        // Function Call
        substringOccurrence(pat, txt, q);
    }

    public static void substringOccurrence(String pattern, String txt, int q) {

        int n = txt.length();
        int m = pattern.length();

        int p = 0;
        int t = 0;

        int h = 1;

        for(int i = 0; i < m-1; i++) {
            h = (h*d) % q;
        }

        for(int i = 0; i < m; i++) {
            p = (p*d + pattern.charAt(i)) % q;
            t = (t*d + txt.charAt(i)) % q;
        }

        for(int i = 0; i <= n-m; i++) {

            if( p == t) {
                int j = 0;
                for(; j < m; j++) {
                    if(txt.charAt(i+j) != pattern.charAt(j)) {
                        break;
                    }
                }

                if( j == m) {
                    System.out.println(i);
                }
            }

            if( i < n-m) {

                t = (d*(t - txt.charAt(i)*h) + txt.charAt(i+m)) % q;
            }

            if( t < 0) {
                t = t+q;
            }
        }
    }

}

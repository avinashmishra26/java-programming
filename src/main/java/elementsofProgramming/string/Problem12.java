package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 17/09/21.
 */
public class Problem12 {

    public static void main(String[] args) {

        System.out.println(encoding("aaaabcccaa"));


        System.out.println(decoding("4a1b3c2a"));
    }

    private static String encoding(String input) {

        int tempCount = 1;
        char tempCh = input.charAt(0), t;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= input.length(); i++) {
            if (i == input.length() || input.charAt(i) != tempCh) {
                sb.append(tempCount);
                sb.append(tempCh);
                if (i != input.length() ) {
                    tempCh = input.charAt(i);
                    tempCount = 1;
                }
            } else {
                tempCount++;
            }
        }
        return sb.toString();
    }


    private static String decoding(String input) {

        StringBuilder s = new StringBuilder();
        int cnt = 0;

        for (int i = 0; i < input.length(); ++i) {
            char c  = input.charAt(i);
            if (Character.isDigit(c)) {
                cnt = c - '0';
            } else {
                while (cnt > 0) {
                    s.append(c);
                    cnt --;
                }
                cnt = 0;
            }
        }
        return s.toString();
    }
}

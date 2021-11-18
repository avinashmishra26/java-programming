package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 17/09/21.
 * Decode a string
 */
public class Problem11_Extension {

    public static void main(String[] args) {
        System.out.print(decodeString(3, "mnesi___ya__k____mime"));
    }

    static String decodeString(int numberOfRows, String encodedString) {
        int i = 0, start = 0;
        int strLen = encodedString.length();
        int eachRow = strLen/numberOfRows - 1;

        StringBuilder br = new StringBuilder();

        while (true) {
            if (i >= strLen) {
                start += 1;
                i = start;
            }
            char c = encodedString.charAt(i);

            br.append(c == '_' ? ' ' : c);
            if (i == eachRow) {
                break;
            }
            i += 8;
        }
        return br.toString().trim();
    }
}

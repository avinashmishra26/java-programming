package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 17/09/21.
 */
public class Problem11 {

    public static void main(String[] args) {
        System.out.print(snakeString("Hello_World!"));
    }

    static String snakeString(String input) {
        StringBuilder stringBuilder = new StringBuilder();

        int strLen = input.length();

        for (int i=1; i< strLen; ) {
            stringBuilder.append(input.charAt(i));
            i += 4;
        }

        for (int i=0; i< strLen; ) {
            stringBuilder.append(input.charAt(i));
            i += 2;
        }

        for (int i=3; i< strLen; ) {
            stringBuilder.append(input.charAt(i));
            i += 4;
        }

        return stringBuilder.toString();
    }
}

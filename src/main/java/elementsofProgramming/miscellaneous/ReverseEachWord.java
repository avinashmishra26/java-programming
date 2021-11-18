package elementsofProgramming.miscellaneous;

/**
 * Created by avinashkumarmishra on 04/10/21.
 * REVERSE ALL THE WORDS IN A SENTENCE
 */
public class ReverseEachWord {

    public static void main(String[] args) {
        System.out.print(reverseWordsInSentence("I am Avinash, I stay in Uk"));
    }

    public static String reverseWordsInSentence(String s) {
        String[] words = s.split("\\s");

        StringBuilder stringBuilder = new StringBuilder();

        for ( String word : words) {
            stringBuilder.append(reverse(word));
            stringBuilder.append(" ");
        }

        return stringBuilder.toString();
    }

    private static StringBuilder reverse(String word) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = word.length() -1; i >= 0; i--) {
            stringBuilder.append(word.charAt(i));
        }
        return stringBuilder;
    }
}

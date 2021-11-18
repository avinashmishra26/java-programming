package elementsofProgramming.string;

/**
 *  Created by avinashkumarmishra on 04/10/21.
 *  REVERSE ALL THE WORDS IN A SENTENCE
 * "Alice likes Bob" transforms to "Bob likes Alice"
 */
public class Problem6 {

    public static void main(String[] args) {

        char[] input  = "My name is Avinash".toCharArray();
        reverseWords(input);
        for(int i = 0; i < input.length ; i++ ) {
            System.out.print(input[i]);
        }
    }

    public static void reverseWords(char[] input) {

        reverse(input, 0, input.length - 1);

        int start = 0, end;
        while ( (end = findNextSpace(input, start, ' ')) != input.length ) {
            reverse(input, start, end-1);
            start = end + 1;
        }

        reverse(input, start, end-1);

    }

    private static int findNextSpace(char[] input, int start, char search) {

        while (start < input.length && input[start] != search){
            start++;
        }

        return start;
    }

    private static void reverse(char[] input, int start, int stopIndex) {

        for(int i = start, j = stopIndex; i <= (start + stopIndex)/2 && i < j; i++, j--) {
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
        }
    }
}

package programming.level2.arrayAndString;

/**
 * Created by avinash on 19/04/2022.
 *
 * https://leetcode.com/problems/long-pressed-name
 */
public class Faultykeyboard {

        public static void main(String[] args) {
            System.out.print(faultyKeyboard("mannu", "mmaannuu"));
        }


        private static boolean faultyKeyboard(String name, String typed) {

        if(name.length() > typed.length()) return false;

        int i = 0;
        int j = 0;

        while(i < name.length() && j < typed.length()) {
            if(name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (i > 0 && name.charAt(i-1) == typed.charAt(j)) {
                j++;
            } else {
                return false;
            }
        }
        if(i < name.length()) return false;

        while(j < typed.length()) {
            char lastChar = name.charAt(name.length()-1);
            if(typed.charAt(j) != lastChar) {
                return false;
            }
            j++;
        }
        return true;
    }
}

package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 11/10/21.
 */
public class Problem8_LookAndSay {

    public static void main(String[] args) {
        System.out.println(lookAndSay(8));
    }

    static String lookAndSay(int a) {

        StringBuilder s = new StringBuilder("1");
        for ( int i = 2; i <= a; i++) {
            StringBuilder temp = new StringBuilder();
            int cnt = 1;
            char c = s.charAt(0);
            for (int j = 1; j < s.length(); j++ ) {
                    if( s.charAt(j) == c){
                        cnt++;
                    } else {
                        temp.append(cnt); temp.append(c);
                        c = s.charAt(j);
                        cnt = 1;
                    }
            }
            temp.append(cnt+""); temp.append(c);
            s = temp;
        }
        return s.toString();
    }
}

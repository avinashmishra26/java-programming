package elementsofProgramming.string;

import java.util.*;

/**
 * Created by avinashkumarmishra on 11/10/21.
 */
public class problem7_Mnemonics {

    public static Map<Character,String> numberMapping = new HashMap<>();
    static {
        numberMapping.put('2',"ABC");
        numberMapping.put('3',"DEF");
        numberMapping.put('4',"GHI");
        numberMapping.put('5',"JKL");
        numberMapping.put('6',"MNO");
        numberMapping.put('7',"PQRS");
        numberMapping.put('8',"TUV");
        numberMapping.put('9',"WXYZ");
    }

    public static void main(String[] args) {

        List<String> allValid = new ArrayList<>();
        mnemonics("23".toCharArray(), 0,  allValid, "");

        allValid.forEach(e -> System.out.println(e));
    }

    public static void mnemonics(char[] number,int idx, List<String> allValid, String start) {
        if(number.length == idx){
            allValid.add(start);
            return;
        }


        String s = numberMapping.get(number[idx]);
        for (int i=0; i <s.length() ; i++) {
            mnemonics(number, idx+1, allValid, start+s.charAt(i));
        }

    }


}

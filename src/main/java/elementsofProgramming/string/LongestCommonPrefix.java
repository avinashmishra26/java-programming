package elementsofProgramming.string;

/**
 * Created by avinashkumarmishra on 29/10/21.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        System.out.print(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public static String longestCommonPrefix(String[] strs) {



        StringBuilder res = getLongestStr(strs);

        return res != null ? res.toString() : "";
    }

    private static StringBuilder getLongestStr(String[] strs){
        StringBuilder sb = null;

        int len = strs[0].length();
        int start = 0;
        int end = len/2;
        boolean notFound;



        while(start < end && end < len) {
            notFound = false;
            for(int i = 1; i< strs.length; i++) {
                if(!strs[i].contains(strs[0].substring(start, end+1))){
                    notFound = true;
                    break;
                }
            }
            if(notFound) {
                end /= 2;
                if(sb != null) {
                    break;
                }
            } else {
                sb = new StringBuilder(strs[0].substring(start, end+1));
                end +=1 ;
            }
        }

        return sb;

    }
}

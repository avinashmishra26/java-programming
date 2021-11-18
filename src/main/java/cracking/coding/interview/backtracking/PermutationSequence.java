package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 14/10/21.
 */
public class PermutationSequence {


    public static void main(String[] args) {
        System.out.print("val :"+getPermutation(4,9));
    }

    public static String getPermutation(int n, int k) {
        return startPermute(new int[n], 1, n,  new int[]{k-1});
    }

    private static String startPermute(int[] box, int start, int end, int[] elementId){
        if(start > end) {
            if (elementId[0] == 0) {
                StringBuilder st = new StringBuilder();
                for ( int i =0; i< box.length; i++ )
                    st.append(box[i]);
                return st.toString();
            }
            elementId[0] = elementId[0] - 1;
            return "";
        }

        String res = "";

        for (int i = 0; i< box.length; i++) {
            if ( box[i] == 0){
                box[i] = start;
                if( (res = startPermute(box, start+1, end, elementId)) != "") {
                    return res;
                }
                box[i] = 0;
            }
        }
        return "";
    }
}

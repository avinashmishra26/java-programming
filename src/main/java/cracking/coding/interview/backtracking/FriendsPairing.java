package cracking.coding.interview.backtracking;

/**
 * Created by avinashkumarmishra on 11/11/21.
 */
public class FriendsPairing {

    public static void main(String[] args) {
        friendPair(4, new boolean[5], "");
    }

    private static void friendPair(int n, boolean[] boxes, String ssf) {

        if(allBoxes(boxes)) {
            System.out.println(ssf.substring(0,ssf.length()-1));
            return;
        }

        int i = 1;

        while(i < boxes.length && boxes[i] != false) i++;

        //alone stay
        boxes[i] = true;
        friendPair(n, boxes, ssf+i+"_");

        for( int j = i+1; j <= n; j++){
            if(boxes[j] == false) {
                boxes[j] = true;
                friendPair(n, boxes, ssf + i +""+ j + "_");
                boxes[j] = false;
            }
        }

        boxes[i] = false;
    }

    private static boolean allBoxes(boolean[] boxes) {

        for(int i = 1; i < boxes.length; i++) {
            if(boxes[i] == false) {
                return false;
            }
        }
        return true;
    }
}

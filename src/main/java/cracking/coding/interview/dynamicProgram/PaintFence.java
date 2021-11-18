package cracking.coding.interview.dynamicProgram;

/**
 * Created by avinashkumarmishra on 30/10/21.
 *  Paint fence : Not more 2 consecutive fence have the same color.
 *  Remember there can be a permutation where different color can appear together, i means like rrbb,
 */
public class PaintFence {

    private static int totalFenceColor(int fence, int color) {

        if ( fence <= 1) {
            return color;
        }

        int same = color, different = color*(color-1);

        int total = same + different;

        for( int i = 3; i <= fence; i++) {
            same = different;
            different = total*(color-1);
            total = same+different;
        }

        return total;
    }
}

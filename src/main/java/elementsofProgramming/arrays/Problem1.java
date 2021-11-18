package elementsofProgramming.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by avinashkumarmishra on 23/09/21.
 */
public class Problem1 {

    public static void main(String[] args) {
        List<Color> res = dutchFlagPartition(Color.WHITE.ordinal(), Arrays.asList(Color.NIL, Color.BLACK, Color.WHITE, Color.NIL, Color.BLACK, Color.WHITE, Color.WHITE));

       res.forEach(e -> System.out.print(e + " "));
    }

    private static enum Color {NIL, WHITE, BLACK};

    public static List<Color> dutchFlagPartition(int pivotIndex, List<Color> a) {
        Color pivot = a.get(pivotIndex) ;

        int smaller = 0, equal= 0, larger = a.size();

        while (equal < larger) {

            if ( a.get(equal).ordinal() < pivot.ordinal()) {
                Collections.swap(a, smaller++, equal++);
            } else if ( a.get(equal).ordinal() == pivot.ordinal()) {
                ++equal;
            } else {
                Collections.swap(a, equal, --larger);
            }

        }
        return a;
    }
}

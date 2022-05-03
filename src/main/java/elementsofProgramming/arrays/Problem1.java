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

        int[] flags = {0,1,2,0,1,2,0,2};
        dutchFlagSepration(flags);

        System.out.println("\nNew Method");

        for(int i = 0; i < flags.length; i++) {
            System.out.print(flags[i]);
        }
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

    //Another approach -- same just dealing with Arrays
    private static void dutchFlagSepration(int[] nums) {

        for(int i = 0, j = 0, k = nums.length-1; j < k; ) {

            if(nums[j] == 0) {
                mySwap(nums, i, j);
                i++;
                j++;
            } else if(nums[j] == 1) {
                j++;
            } else {
                mySwap(nums, j, k);
                k--;
            }

        }
    }

    private static void mySwap(int[] nums, int p1, int p2) {
        int t = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = t;
    }
}

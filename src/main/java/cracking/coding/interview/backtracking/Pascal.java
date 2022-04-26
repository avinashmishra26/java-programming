package cracking.coding.interview.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by avinash on 13/04/2022.
 */
public class Pascal {


    public static void main(String[] args) {
        System.out.print(getPascal(5));
    }

    private static List<Integer> getPascal(int row) {

        List<Integer> res = new ArrayList<>();
        res.add(1);

        for(int i = 1; i < row; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(1); temp.add(1);

            for(int j = 0; j < res.size()-1; j++) {
                int t = res.get(j) + res.get(j+1);
                temp.add(j+1, t);
            }

            res = temp;
        }

        return res;

    }
}

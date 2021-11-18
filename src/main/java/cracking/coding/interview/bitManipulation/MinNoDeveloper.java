package cracking.coding.interview.bitManipulation;

import java.util.HashMap;

/**
 * Created by avinashkumarmishra on 08/11/21.
 */
public class MinNoDeveloper {

    public static void main(String[] args) {
        //There are total 5 skills
        String[] skills = {"a", "b", "c", "d", "e"};

        // people 1 have skill a, c
        // people 2 have skill b, d
        // people 3 have skill b,c,d
        // people 4 have skill e
        String[] peopleSkills = { "a,c", "b,d", "bcd", "e"};

        HashMap<String, Integer> smap = new HashMap<>();
        for(int i = 0; i < skills.length; i++) {
            smap.put(skills[i], i);
        }
    }
}

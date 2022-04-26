package programming.level2.arrayAndString;

import java.util.*;

/**
 * Created by avinash on 23/04/2022.
 */
public class MajorityElement_K {


    public static void main(String[] args) {
        System.out.println(getMajorityK(new int[]{2,2,1,1,1,2,2}, 3));

        //System.out.println(majorityElement(new int[]{1,1,1,2,2,2,3,3}));
    }

    private static List<Integer> getMajorityK(int[] nums, int k){

        HashMap<Integer, Integer> map = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int nLen = nums.length / k;

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() > nLen) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}

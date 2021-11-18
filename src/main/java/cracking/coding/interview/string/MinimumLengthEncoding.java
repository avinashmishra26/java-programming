package cracking.coding.interview.string;

import java.util.*;

/**
 * Created by avinashkumarmishra on 16/10/21.
 * "time", "me", "bell" => "time$me$bell"
 */
public class MinimumLengthEncoding {

    public static void main(String[] args) {
        System.out.print(minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    public static int minimumLengthEncoding(String[] words) {
        Map<String, Integer> res = new HashMap<>();
        int totalval = 0;
        boolean takencare = false;
        for(String word : words) {
            takencare = false;
            for (Map.Entry<String, Integer> mp: res.entrySet()) {
                String mp_key = mp.getKey();
                int w_l = word.length();
                int m_l =  mp_key.length();
                if(mp_key.contains(word) && mp_key.substring(m_l-w_l).equals(word)){
                    takencare = true;
                    break;
                } else if (word.contains(mp_key) && word.substring(w_l-m_l).equals(mp_key)) {
                    totalval -= res.get(mp_key);
                    res.remove(mp_key);
                    res.put(word, w_l);
                    totalval += w_l;
                    takencare = true;
                    break;
                }
            }
            if (!takencare) {
               res.put(word, word.length());
               totalval += word.length();
               totalval += 1;

            }
        }
        return totalval;
    }
}

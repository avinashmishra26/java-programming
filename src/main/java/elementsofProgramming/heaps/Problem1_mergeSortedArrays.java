package elementsofProgramming.heaps;

import java.util.*;

/**
 * Created by avinashkumarmishra on 13/10/21.
 * Merge sorted files
 */
public class Problem1_mergeSortedArrays {

    public static void main(String[] args) {
        mergeSortedArrays(Arrays.asList(Arrays.asList(3,5,7), Arrays.asList(0,6), Arrays.asList(0,6,28)))
        .forEach(e -> System.out.print(e +" "));
    }

    private static class ArrayEntry {
        int value;
        int arrayId;
        int idx;

        ArrayEntry(int value, int arrayId, int idx) {
            this.value = value;
            this.arrayId = arrayId;
            this.idx = idx;
        }
    }

    private static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {

        PriorityQueue<ArrayEntry> arrayEntries = new PriorityQueue<>(sortedArrays.size(), new Comparator<ArrayEntry>() {
            @Override
            public int compare(ArrayEntry o1, ArrayEntry o2) {
                return Integer.compare(o1.value, o2.value);
            }
        });

        List<Integer> res = new ArrayList<>();

        for (int i = 0 ; i < sortedArrays.size(); i++ ) {
            arrayEntries.add(new ArrayEntry(sortedArrays.get(i).get(0), i, 0));
        }

        while(!arrayEntries.isEmpty()) {
            ArrayEntry entry = arrayEntries.poll();
            res.add(entry.value);
            if (entry.idx < (sortedArrays.get(entry.arrayId).size()-1)) {
                entry.idx++;
                arrayEntries.add(new ArrayEntry(sortedArrays.get(entry.arrayId).get(entry.idx), entry.arrayId, entry.idx));
            }
        }
        return res;
    }
}

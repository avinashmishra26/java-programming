package cracking.coding.interview.backtracking.basic;

/* Created by avinashkumarmishra on 22/03/22.
*  2022
*/

public class ElementOccurrence {

    public static void main(String[] args) {
        System.out.println(firstOccurrence(new int[]{22,8,4,8,7},0, 8));

        System.out.println(LastOccurrence(new int[]{22,8,4,8,7},0, 8));


        for(int idx : allOccurrence(new int[]{22,8,4,8,7},0, 8, 0))
            System.out.print(idx + " ");
    }

    public static int firstOccurrence(int[] arr, int idx, int element) {
        if(arr.length == idx){
            return -1;
        } else if (arr[idx] == element){
            return idx;
        }
        return firstOccurrence(arr, idx+1, element);

    }

    public static int LastOccurrence(int[] arr, int idx, int element) {
        if(arr.length == idx){
            return -1;
        }

        int lastIdx = LastOccurrence(arr, idx+1, element);

        if (lastIdx == -1 && arr[idx] == element){
            return idx;
        } else {
            return lastIdx;
        }

    }

    public static int[] allOccurrence(int[] arr, int idx, int x,int fsf) {
        if(arr.length == idx){
            return new int[fsf];
        }

        int cnt = fsf;
        if(arr[idx] == x) {
            cnt++;
        }

        int[] res = allOccurrence(arr, idx+1, x, cnt);

        if(cnt > fsf) {
            res[fsf] = idx;
        }

        return res;

    }
}
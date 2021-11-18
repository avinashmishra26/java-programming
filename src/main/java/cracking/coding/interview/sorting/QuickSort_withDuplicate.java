package cracking.coding.interview.sorting;

/**
 * Created by avinashkumarmishra on 27/10/21.
 * QuickSort with Duplicate ( Dutch Flag problem). Solve in 0(n). Just perform single Pass with pivot as 1.
 * Assumption is that we have only 0,1,2 in the array
 */
public class QuickSort_withDuplicate {


    public static void main(String[] args) {
        int[] nums = {0,1,0,1,2,0,1};
        sortColors(nums, 1);

        for(int i =0; i< nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
    }



    private static void sortColors(int[] nums, int pivot) {

        for(int i = 0, j = 0, k = nums.length; j < k;) {
            int val = nums[j];
            if(val > pivot){
                swapColors(nums, --k, j);
            } else if( val == pivot) {
                j++;
            } else {
                swapColors(nums, i, j);
                i++;
                j++;
            }
        }
    }

    private static void swapColors(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

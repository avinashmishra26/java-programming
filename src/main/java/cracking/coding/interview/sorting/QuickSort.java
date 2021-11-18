package cracking.coding.interview.sorting;

/**
 * Created by avinashkumarmishra on 27/10/21.
 * Quick Sort
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {9,6,10,2,5};
        quickSort(nums, 0, nums.length-1);

        for(int i =0; i< nums.length; i++) {
            System.out.print(nums[i] +" ");
        }
    }

    private static void quickSort(int[] nums, int start, int end) {

        if(start < end) {
            int idx = getPivot(nums, start, end);
            quickSort(nums, start, idx-1);
            quickSort(nums, idx+1, end);
        }
    }



    private static int getPivot(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start, j = end+1;

        while(i < j) {

            while(++i <= end && nums[i] < pivot);

            while(--j > start && nums[j] > pivot);

            if ( i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j]=temp;
            }
        }

        if ( j != start) {
            int temp = nums[j];
            nums[j] = nums[start];
            nums[start] = temp;
        }

        return j;
    }
}

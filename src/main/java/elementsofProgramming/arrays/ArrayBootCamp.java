package elementsofProgramming.arrays;

/**
 * Created by avinashkumarmishra on 23/09/21.
 */
public class ArrayBootCamp {

    public static void main(String[] args) {
        int[] a = reArrangeEvenOdd(new int[]{5,8,6,7,1,9,2});
        for (int a1 : a) {
            System.out.print(a1 +" ");
        }
    }

    static int[] reArrangeEvenOdd(int[] arr) {

        int i =0, j =  arr.length;
        int len = j;
        j = j-1;

        while (i < j) {

            while (i < j && i < len && (arr[i] % 2 == 0)){
                i += 1;
            }

            while (i < j && j >= 0 && (arr[j] % 2 != 0)){
                j -= 1;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i += 1;
                j -= 1;
            }
        }
        return arr;
    }
}

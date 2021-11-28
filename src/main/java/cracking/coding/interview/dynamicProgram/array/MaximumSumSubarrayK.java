package cracking.coding.interview.dynamicProgram.array;

/**
 * Created by avinashkumarmishra on 25/10/21.
 * Maximum Sum Subarray with at least Size K-element | Dynamic Programming
 */
public class MaximumSumSubarrayK {

    public static void main(String[] args) {
        System.out.println(maxSubarrayUsingKadaneForKElement(new int[]{2, 3, 1, -7, 6, -5, -4, 4, 3, 3, 2, -9, -5, 6, 1, 2, 1, 1}, 4));


    }

    static int maxSubarrayUsingKadaneForKElement(int[] arr, int k) {
        int maxCurrent = 0;
        int[] arrKadane = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {

            maxCurrent += arr[i];
            arrKadane[i] = maxCurrent;

            if(maxCurrent < arr[i]) {
                maxCurrent = arr[i];
                arrKadane[i] = maxCurrent;
            }

        }

        int maxAtleastKElement = Integer.MIN_VALUE;
        int justKEle = 0;
        int kAndkadanne = 0;

        for( int i = 0; i < k; i++) {
            justKEle += arr[i];
        }

        maxAtleastKElement = justKEle;

        for(int i = k ; i < arr.length; i++){

            justKEle = justKEle + arr[i] - arr[i-k];

            kAndkadanne = justKEle + arrKadane[i-k];

            if(kAndkadanne > maxAtleastKElement || justKEle > maxAtleastKElement) {
                maxAtleastKElement = kAndkadanne > justKEle ? kAndkadanne : justKEle;
            }

        }
        return maxAtleastKElement;
    }
}

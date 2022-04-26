package blindQuestions;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by avinash on 15/04/2022.
 * https://leetcode.com/problems/3sum/
 */
public class Problem9 {


    public static void main(String[] args) {
        ArrayList<int[]> res = sum3(new int[]{3, -3, 4, -3, 1, 2});

        res.forEach(r -> System.out.println(r[0] + " "+ r[1]+ " "+r[2]));
    }

    private static ArrayList<int[]>  sum3(int[] arr) {

        ArrayList<int[]> res = new ArrayList<>();

        Arrays.sort(arr);

        int targetSum = 0;

        for(int i = 0; i < arr.length-2; i++) {
            int curr = arr[i];
            int l = i+1;
            int r = arr.length-1;

            while(l < r && l < arr.length-1) {

                int leftV = arr[l];
                int rightV = arr[r];

                int sum = arr[i] + leftV + rightV;

                if(sum < targetSum) {
                    l++;
                    while(l < arr.length-1 && arr[l] == leftV) {
                        l++;
                    }

                } else if ( sum > targetSum) {
                    r--;
                    while(r > i && arr[r] == rightV) {
                        r--;
                    }

                } else {
                    res.add(new int[]{arr[i], arr[l], arr[r]});
                    while(r > i && arr[r] == rightV) {
                        r--;
                    }
                }

            }
            while(i < arr.length-1 && arr[i+1] == curr) {
                i++;
            }
        }
        return res;

    }
}

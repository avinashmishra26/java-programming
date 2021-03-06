package programming.level2.arrayAndString;

/**
 * Created by avinash on 19/04/2022.
 */
public class RotateArray {


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        rotate(matrix);
        int maxSize = matrix.length;

        for(int i = 0; i < maxSize; i++){
            for(int j = 0; j < maxSize; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix) {

        int maxSize = matrix.length;

        //transpose
        for(int g = 0; g < maxSize; g++) {

            for(int i = g, j = g; j < maxSize ; j++ ) {
                if( i != j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }

        //reverse each row
        for(int i = 0; i < maxSize; i++) {
            int j = 0, k = maxSize-1;
            while(j < k) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[i][k];
                matrix[i][k] = t;
                j++;
                k--;
            }
        }

    }
}

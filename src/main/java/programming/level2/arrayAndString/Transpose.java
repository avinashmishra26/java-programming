package programming.level2.arrayAndString;

/**
 * Created by avinash on 03/05/2022.
 */
public class Transpose {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        transpose(matrix);
        int maxSize = matrix.length;

        for(int i = 0; i < maxSize; i++){
            for(int j = 0; j < maxSize; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    //another way of gap-theorem
    public static void transpose(int[][] matrix) {

        int maxSize = matrix.length;

        //transpose
        for (int i = 0; i < maxSize; i++) {

            for (int j = 0; j < maxSize; j++) {
                if (i < j) {
                    int t = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = t;
                }
            }
        }
    }
}

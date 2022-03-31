package amazon;

public class SearchMatrix {

    public static void main(String[] args) {
        System.out.print(searchMatrix(new int[][]{{1}}, 2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        for(int col=matrix[0].length-1; i < matrix.length; i++) {
            if(matrix[i][col] >= target) {
                break;
            }
        }
        if(i == matrix.length) return false;

        //binary search
        int start = 0;
        int end = matrix[0].length-1;

        while(start <= end) {
            int mid = (start+end)/2;
            if(matrix[i][mid] > target) {
                end = mid-1;
            } else if(matrix[i][mid] == target){
                return true;
            } else {
                start = mid+1;
            }
        }
        return false;
    }
}
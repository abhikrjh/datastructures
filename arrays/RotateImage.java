package arrays;

/*
You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]

Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
*/

public class RotateImage {

    private static void rotate(int[][] matrix) {

        // transpose the matrix (convert row to column)
        // 1, 2, 3                      1, 4, 7
        // 4, 5, 6    ---transpose--->  2, 5, 8
        // 7, 8, 9                      3, 6, 9


        for (int i = 0; i < matrix.length; i++) { // row

            for (int j = i + 1; j < matrix[i].length; j++) { // column

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }


        // reverse each row
        // 1, 4, 7                      7, 4, 1
        // 2, 5, 8    ---reverse--->    8, 5, 2
        // 3, 6, 9                      9, 6, 3

        for (int i = 0; i < matrix.length; i++) {// row

            int left = 0 ; int right = matrix.length-1;

            while(left < right){

                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;

                left++;
                right--;
            }
        }
    }

    private static void print(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                System.out.print(matrix[i][j] + ", ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

//        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};

        rotate(matrix);

        // print the rotated matrix

        print(matrix);
    }
}

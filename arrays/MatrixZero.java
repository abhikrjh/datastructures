package arrays;
/*
Problem Statement: Given a matrix if an element in the matrix is 0 then,
 you will have to set its entire column and row to 0 and then return the matrix.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixZero {


    private static void markZero(List<List<Integer>> matrix) {

        int row = matrix.size();
        int col = matrix.get(0).size();

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (matrix.get(i).get(j) == 0) {

                    markRowAsMinusOne(matrix, col, i);
                    markColAsMinusOne(matrix, row, j);
                }
            }
        }

        // mark all -1 as 0 now
        markAllMinusOneAsZero(matrix, row, col);

        System.out.println(matrix.toString());
    }

    private static void markRowAsMinusOne(List<List<Integer>> matrix, int col, int i) {

        // set all non-zero elements as -1 in the row i:
        for (int k = 0; k < col; k++) {

            if (matrix.get(i).get(k) != 0) {

                matrix.get(i).set(k, -1);
            }
        }
    }

    private static void markColAsMinusOne(List<List<Integer>> matrix, int row, int j) {

        // set all non-zero elements as -1 in the col j:
        for (int l = 0; l < row; l++) {

            if (matrix.get(l).get(j) != 0) {

                matrix.get(l).set(j, -1);
            }
        }

    }

    private static void markAllMinusOneAsZero(List<List<Integer>> matrix, int row, int col) {

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                if (matrix.get(i).get(j) == -1) {

                    matrix.get(i).set(j, 0);
                }
            }
        }
    }

    public static void main(String[] args) {

        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        markZero(matrix);
    }
}

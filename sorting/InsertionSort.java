package sorting;

// 4, 5, 3, 1, 2

// First Step : compare 5 with 4, do nothing because its already sorted // 4, 5, 3, 1, 2

// Second Step :  Compare 3 with 5 and 4, swap 3 with 5 and again 3 with 4 // 3, 4, 5 , 1, 2

// Third Step : Compare 1 with 5,4,3 separately and swap // 1, 3, 4, 5 , 2

// Forth Step : Compare 2 with all its previous and swap // 1, 2, 3, 4, 5

import java.util.Arrays;

public class InsertionSort {

    static void insertionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = i + 1; j > 0; j--) {

                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    private static void swap(int[] arr, int j, int previousOfJ) {
        int temp = arr[j];
        arr[j] = arr[previousOfJ];
        arr[previousOfJ] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 3, 1, 2, 0, 6};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

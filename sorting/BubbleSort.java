package sorting;

// 3, 1, 5, 4, 2

import java.util.Arrays;

// repeatedly swap adjacent element if they are in wrong order
public class BubbleSort {


    static void sort(int[] arr) {

        // int[] arr = {3, 1, 5, 4, 2};

        for (int i = 0; i < arr.length; i++) {

            boolean swapped = false;

            for (int j = 1; j < arr.length - i; j++) {

                int temp;

                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }

            // if no swap happened then its already a sorted array
            if (!swapped)
                break;
        }
        System.out.print("Array after sorting : ");
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4, 2, 7, 6};

        sort(arr);
    }
}

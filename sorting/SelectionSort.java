package sorting;

import java.util.Arrays;


// In selection sort we select the maximum number in the list/array and keep it at right most position

//   OR

// We select the minimum number in the list/array and keep it at left most position

// 4, 5, 1, 2, 3, 8, 7, 6

public class SelectionSort {

    static void selection(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            // find the max item in the array and swap with the correct index

            int lastIndex = arr.length - (i + 1);

            int maxIndex = getMaxIndex(arr, 0, lastIndex);

            swapLastElementWithMaxElement(arr, maxIndex, lastIndex);

        }
    }

    static void swapLastElementWithMaxElement(int[] arr, int maxIndex, int lastIndex) {

        int temp = arr[lastIndex];
        arr[lastIndex] = arr[maxIndex];
        arr[maxIndex] = temp;
    }

    private static int getMaxIndex(int[] arr, int startIndex, int lastIndex) {

        int max = startIndex;

        for (int i = startIndex; i <= lastIndex; i++) {

            if (arr[i] > arr[max]) {
                max = i;
            }

        }
        return max;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3, 8, 7, 6};

        System.out.println("Before sorting : " + Arrays.toString(arr));

        selection(arr);

        System.out.println("Before sorting : " + Arrays.toString(arr));
    }

}

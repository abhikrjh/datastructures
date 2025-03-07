package sorting;
/*

Divide:  Divide the list or array recursively into two halves until it can no more be divided.
Conquer:  Each subarray is sorted individually using the merge sort algorithm.
Merge:  The sorted subarrays are merged back together in sorted order.
        The process continues until all elements from both subarrays have been merged.

Example

Divide

    [38, 27, 43, 10]  is divided into  [38, 27  ] and  [43, 10].
    [38, 27]  is divided into  [38]  and  [27].
    [43, 10]  is divided into  [43]  and  [10].

Conquer:

    [38]  is already sorted.
    [27]  is already sorted.
    [43]  is already sorted.
    [10]  is already sorted.

Merge:

    Merge  [38]  and  [27]  to get  [27, 38].
    Merge  [43]  and  [10]  to get  [10,43].
    Merge  [27, 38]  and  [10,43]  to get the final sorted list  [10, 27, 38, 43].
    Therefore, the sorted list is  [10, 27, 38, 43].

*/

// Input = [6, 3, 5, 4, 1, 2] , Output = [1, 2, 3, 4, 5, 6]

import java.util.Arrays;

public class MergeSort {

    static int[] mergeSort(int[] arr){

        return divide(arr);
    }

    static int[] divide(int[] arr) {

        // Base condition
        if (arr.length == 1)
            return arr;

        int mid = arr.length / 2;

        int[] firstHalf = divide(Arrays.copyOfRange(arr, 0, mid));
        int[] secondHalf = divide(Arrays.copyOfRange(arr, mid, arr.length));

        return conquer(firstHalf, secondHalf);
    }

    private static int[] conquer(int[] firstHalf, int[] secondHalf) {

        int[] mixArray = new int[firstHalf.length + secondHalf.length];

        int i = 0; // This pointer is for first array
        int j = 0; // This pointer is for second  array
        int k = 0; // This pointer is for mix array

        while (i < firstHalf.length && j < secondHalf.length) {

            if (firstHalf[i] < secondHalf[j]) {

                mixArray[k] = firstHalf[i];
                i++;
            } else {

                mixArray[k] = secondHalf[j];
                j++;
            }

            k++;
        }

        // It is possible that one of the array is not complete
        // Copy the remaining element

        while (i < firstHalf.length) {
            mixArray[k] = firstHalf[i];
            i++;
            k++;
        }

        while (j < secondHalf.length) {
            mixArray[k] = secondHalf[j];
            j++;
            k++;
        }
        return mixArray;
    }

    public static void main(String[] args) {

        int[] arr = {6, 3, 5, 4, 1, 2};

        int[] sortedArray = mergeSort(arr);

        System.out.println(Arrays.toString(sortedArray));
    }
}

package binarysearch;

public class BinarySearch {

    // return the index
    // return -1 if it does not exit.
    private static int binarySearch(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        while (startIndex <= endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (target < arr[middleIndex]) {

                endIndex = middleIndex - 1;
            } else if (target > arr[middleIndex]) {

                startIndex = middleIndex + 1;
            } else {

                return middleIndex;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 5, 7, 14, 16, 19};
        int target = 7;

        int i = binarySearch(arr, target);

        System.out.println("Searched Index of " + target + " is : " + i);
    }
}

package binarysearch;

public class BinarySearch {

    // return the index
    // return -1 if it does not exit.
    private static int binarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mId = start + (end - start) / 2;

            if (target < arr[mId]) {

                end = mId - 1;
            } else if (target > arr[mId]) {

                start = mId + 1;
            } else {

                return mId;
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

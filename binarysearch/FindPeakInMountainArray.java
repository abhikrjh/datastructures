package binarysearch;


// Find peak in Mountain array or bitonic array

// A bitonic array is a sequence of numbers that increases and then decreases

// Input : [0,1,0] , o/p : 1
// Input : [1,3,5,7,9,11, 12, 10,9,7,6] , o/p : 12


public class FindPeakInMountainArray {


    private static int findPeakInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return arr[start]; // here start == end we can return any
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 12, 16, 10, 9, 7, 6};
        int peak = findPeakInMountainArray(arr);
        System.out.println(peak);
    }
}

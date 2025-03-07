package binarysearch;

// Leetcode 1095 : https://leetcode.com/problems/find-in-mountain-array/

/*
Input: mountainArr = [1,2,3,4,5,3,1], target = 3
Output: 2
Explanation: 3 exists in the array, at index=2 and index=5. Return the minimum index, which is 2.
Example 2:

Input: mountainArr = [0,1,2,4,2,1], target = 3
Output: -1
Explanation: 3 does not exist in the array, so we return -1.
*/

public class FindInMountainArray {

    private static int search(int[] arr, int target) {

        int peakIndex = findPeakIndexInMountainArray(arr);

        int index = -1;

        // apply binary search in first asc order array which will be from start to peakIndex

        index = binarySearch(arr, target, 0, peakIndex, "ASC");

        if (index != -1 && arr[index] == target) {
            return index;
        }

        // apply binary search in second half of array which is next element after peakIndex to last index

        return binarySearch(arr, target, peakIndex + 1, arr.length - 1, "DESC");
    }


    private static int findPeakIndexInMountainArray(int[] arr) {

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
        return start; // here start == end we can return any
    }

    private static int binarySearch(int[] arr, int target, int start, int end, String order) {
//        We will not be using start and end which we calculate in binary search,
//        rather we will take input from search method above
//        that is why i have commented below start and end


//        int start = 0;
//        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (order.equalsIgnoreCase("ASC")) {

                if (target < arr[mid]) {

                    end = mid - 1;
                } else if (target > arr[mid]) {

                    start = mid + 1;
                } else {

                    return mid;
                }
            } else if (order.equalsIgnoreCase("DESC")) {

                if (target < arr[mid]) {

                    start = mid + 1;
                } else if (target > arr[mid]) {

                    end = mid - 1;
                } else {

                    return mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] mountainArr = {1, 2, 3, 4, 5, 3, 1, 0};
        int target = 3;

        int index = search(mountainArr, target);
        System.out.println(index);
    }

}

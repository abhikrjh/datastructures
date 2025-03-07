package binarysearch;
/*
Search in rotated sorted array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

*/

public class FindInRotatedSortedArray {

    static int findThePivotIndex(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Handle edge cases for pivot detection
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Adjust search space
            if (arr[start] >= arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        // No pivot means the array is not rotated
        return -1;
    }

    static int binarySearch(int[] arr, int target, int start, int end) {

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    static int findTarget(int[] arr, int target) {

        int pivotIndex = findThePivotIndex(arr);

        System.out.println(pivotIndex);

        // If no pivot, array is not rotated, perform simple binary search
        if (pivotIndex == -1) {
            return binarySearch(arr, target, 0, arr.length - 1);
        }

        // If target is at pivot
        if (arr[pivotIndex] == target) {
            return pivotIndex;
        }

        // Determine which side of the array to search

        if(target >= arr[0]){
            return  binarySearch(arr, target, 0, pivotIndex);
        }

        return binarySearch(arr, target, pivotIndex+1, arr.length-1);
    }


    public static void main(String[] args) {

//        int[] arr = {1,2,4,5,6,7,0};
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
//        int[] arr = {1, 3};
        int target = 6;

        System.out.println("target index is : " + findTarget(arr, target));

    }
}

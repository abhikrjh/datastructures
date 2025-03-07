package dsasheet;

// Given an array of integers nums which is sorted in ascending order, and an integer target,
// write a function to search target in nums. If target exists, then return its index.
// Otherwise, return -1. You must write an algorithm with O(log n) runtime complexity.

//Input: nums = [-1,0,3,5,9,12], target = 9

public class FindTarget {

    private static int findIndex(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1,0,3,5,9,12};

        int target = 12;

        int index = findIndex(arr, target);
        System.out.println(index);
    }

}

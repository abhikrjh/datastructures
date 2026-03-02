package binarysearch;
/*
Given an array of integers nums sorted in non-decreasing order,
find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]
*/

import java.util.Arrays;

public class FindFirstAndLastPosition {

    public static int[] searchRange(int[] nums, int target) {

        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        return new int[] {first, last};

    }

    public static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end) {

            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                ans = mid;
                end = mid - 1; // move left
            }else if(nums[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static int findLast(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while(start <= end) {

            int mid = start + (end - start)/2;

            if(nums[mid] == target) {
                ans = mid;
                start = mid + 1; // move right
            }else if(nums[mid] > target) {
                end = mid - 1;
            }else {
                start = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }
}

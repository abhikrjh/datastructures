package blind75;

/*

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function,
nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4


Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1
*/


public class SearchInRotatedSortedArray {

    public static int findThePivotIndex(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            // 4,5,6,7,0,1,2
            if (nums[start] < nums[mid]) {

                if (nums[start] < target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid;
                }
            } else {

                // 6, 7, 0, 1, 2, 3, 4

                if (target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        int[] nums = {4, 5, 6, 7, 0, 1, 2};

        int[] nums = {6, 7, 0, 1, 2, 3, 4};
        int target = 0;


        System.out.println(findThePivotIndex(nums, target));

    }
}

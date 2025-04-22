package arrays;

/*

Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]

Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
*/


import java.util.Arrays;

public class RotateArrayToRight {


    private static int[] rotateRight(int[] nums, int k) {

        // Input : 1,2,3,4,5,6,7   k=3
        // Output :  5,6,7,1,2,3,4

        // Step1 : reverse the entire array
        // 7,6,5,4,3,2,1

        reverseArray(nums, 0, nums.length - 1);

        // Step2 : Reverse the left k elements
        //   5,6,7,4,3,2,1

        reverseArray(nums, 0, k - 1);

        // Step3: Reverse the remaining elements
        // 5,6,7,1,2,3,4

        reverseArray(nums, k, nums.length - 1);

        return nums;
    }

    private static int[] reverseArray(int[] nums, int start, int end) {

        while (start < end) {

            int temp = nums[start];

            nums[start] = nums[end];

            nums[end] = temp;

            start++;
            end--;
        }

        return nums;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(rotateRight(nums, k)));
    }

}


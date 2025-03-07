package arrays;

/*
Given an array of positive integers nums, return the maximum possible sum of an
strictly increasing subarray
in nums.

A subarray is defined as a contiguous sequence of numbers in an array.

Input: nums = [10,20,30,5,10,50]
Output: 65
Explanation: [5,10,50] is the ascending subarray with the maximum sum of 65.

Input: nums = [10,20,30,40,50]
Output: 150
Explanation: [10,20,30,40,50] is the ascending subarray with the maximum sum of 150.
Example
*/

public class LeetCode1800 {

    public static int maxAscendingSum(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        //10,20,30,5,10,50

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] < nums[i + 1]) {

                currentSum = currentSum + nums[i + 1];
            } else {

                maxSum = Math.max(maxSum, currentSum);
                currentSum = nums[i + 1];
            }
        }

        return Math.max(maxSum, currentSum);
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 5, 10, 50};

        int maxSubarraySum = maxAscendingSum(arr);
        System.out.println(maxSubarraySum);

    }
}

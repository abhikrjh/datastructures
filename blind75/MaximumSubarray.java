package blind75;
/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
*/

public class MaximumSubarray {

    private static int maxSubArray(int[] nums) {

        // -2,1,-3,4,-1,2,1,-5,4
        //  4,-1,2,1 = 6

        if (nums.length == 1)
            return nums[0];

        int currentSum = 0;
        int maxSum = nums[0];

        for (int i = 0; i < nums.length; i++) {

            if (currentSum < 0) {  // we are omitting the negative current sum value and starting fresh after that.

                currentSum = 0;
            }

            currentSum += nums[i];

            maxSum = Math.max(currentSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] nums = {-2, -1};

        int maxSum = maxSubArray(nums);

        System.out.println(maxSum);

    }

}

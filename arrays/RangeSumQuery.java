package arrays;
/*
Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
        [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
        numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
*/

public class RangeSumQuery {

    private static int[] prefixSum;

    public RangeSumQuery(int[] nums) {

        int n = nums.length;

        prefixSum = new int[n];

        prefixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    private int sumRange(int left, int right) {

        if (left == 0) {

            return prefixSum[right];
        }

        return prefixSum[right] - prefixSum[left-1];

    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};

        // -2, -2, 1, -4, -2, -3

        RangeSumQuery rangeSumQuery = new RangeSumQuery(nums);

        int sum = rangeSumQuery.sumRange(1, 2);

        System.out.println(sum);
    }
}

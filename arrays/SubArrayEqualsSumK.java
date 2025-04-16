package arrays;

/*
Given an array of integers nums and an integer k, return the total number of
sub-arrays whose sum equals to k.

A sub-array is a contiguous non-empty sequence of elements within an array.

Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
*/

import java.util.HashMap;
import java.util.Map;

public class SubArrayEqualsSumK {

    // 1, 2, 3
    // 1, 3, 6

    private static int subarraySum(int[] nums, int k) {

        int runningSum = 0;
        int subArrayWithSumKCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            runningSum += nums[i];

            // 1, 2, 3, 4

            // 1, 3, 6, 10


            if (map.containsKey(runningSum - k)) {

                subArrayWithSumKCount += map.get(runningSum-k);
            }

            map.put(runningSum,  map.getOrDefault(runningSum, 0) + 1);
        }

        return subArrayWithSumKCount;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4};
        int k = 3;

        int i = subarraySum(nums, k);

        System.out.println(i);
    }
}

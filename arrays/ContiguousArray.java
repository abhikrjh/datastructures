package arrays;

/*
Given a binary array nums, return the maximum length of a contiguous subarray
with an equal number of 0 and 1.


Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
Example 3:

Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {


    private static int findMaxLength(int[] nums) {


        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base condition , in case of input [0,1] so that max length gets updated

        int runningSum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            runningSum += (nums[i] == 0) ? -1 : 1; // replaced 0 with -1 while adding to running sum

            System.out.println("Index: " + i + ", runningSum: " + runningSum); // Debugging line

            if(map.containsKey(runningSum)){

                maxLength = Math.max(maxLength, i - map.get(runningSum)); // current index − first occurrence of the same running sum

            } else {

                map.put(runningSum, i);
            }

        }

        return maxLength;
    }

    public static void main(String[] args) {

//        int[] nums = { 0, 1, 1, 1, 1, 1, 0, 0, 0};
        int[] nums = {0, 1};
        int maxLength = findMaxLength(nums);

        System.out.println(maxLength);
    }
}


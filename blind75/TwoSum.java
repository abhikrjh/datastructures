package blind75;
/*
Given an array of integers nums and an integer target,
return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {

        int left = 0;
        int right = 0;

        while (left <= right) {

            if (right < nums.length - 1) {

                right++;
            } else {

                left++;
                right = left + 1;
            }

            if (nums[left] + nums[right] == target) {

                return new int[]{left, right};
            }
        }

        return new int[]{};
    }

    private static int[] twoSums_optimal(int[] nums, int target) {

        // 2,7,11,15 target =9
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int diff = target - nums[i];

            if (map.containsKey(diff)) {

                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 2, 3};
        int target = 6;

        int[] ints = twoSums_optimal(nums, target);


        System.out.println(Arrays.toString(ints));

    }
}

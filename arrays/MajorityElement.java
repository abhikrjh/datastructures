package arrays;
/*

Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
*/

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    private static int majorityElement(int[] nums) {

        int n = nums.length;
        int existance = (int) Math.ceil(n / 2.0);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.get(nums[i]) != null) {

                map.put(nums[i], map.get(nums[i])+1);
            } else {
                map.put(nums[i], 1);
            }
        }

        System.out.println(map);
        for (Map.Entry<Integer, Integer> entrySet : map.entrySet()) {

            if (entrySet.getValue() >= existance) {

                return entrySet.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2,2,1,1,1,2,2};
//        int[] arr = {3, 2, 3};
        int majorityElement = majorityElement(arr);

        System.out.println(majorityElement);

    }
}

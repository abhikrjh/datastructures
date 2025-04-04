package blind75;
/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (set.contains(num)) {

                return true;
            } else {
                set.add(num);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4};

        boolean isDuplicatePresent = containsDuplicate(nums);

        System.out.println(isDuplicatePresent);

    }
}

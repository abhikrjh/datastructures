package arrays;

/*

Given two integer arrays nums1 and nums2, return an array of their intersection.
 Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]

Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
*/

import java.util.*;
import java.util.stream.Collectors;

public class IntersectionOfTwoArray {

    private static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        // count frequency in nums1

        for (int num : nums1) {

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // check for intersection in nums2

        for (int num : nums2) {

            if(freqMap.containsKey(num) && freqMap.get(num) > 0){

                list.add(num);

                freqMap.put(num, freqMap.get(num)-1);
            }
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {

        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};

        int[] intersect = intersect(nums1, nums2);

        System.out.println(Arrays.toString(intersect));
    }
}
package arrays;

/*
Given an integer array nums and an integer k, return the k most frequent elements.
You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
*/

import java.lang.reflect.Array;
import java.util.*;

public class TopKFrequentElements {

    private static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {

            if (map.get(num) == null) {

                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }

        }

        System.out.println(map);

        int toSkip = map.size() - k;

        int[] array = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .skip(toSkip)
                .sorted(Comparator.reverseOrder())
                .mapToInt(i -> i)
                .toArray();

        return array;
    }

    public static void main(String[] args) {

        // 3, 1, 4, 4, 5, 2, 6, 1

        int[] arr = {3, 1, 4, 4, 5, 2, 6, 1};

        int k = 2;

        int[] ints = topKFrequent(arr, k);

        System.out.println(Arrays.toString(ints));

    }
}

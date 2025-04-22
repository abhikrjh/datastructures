package blind75;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
*/

import java.util.*;

public class ThreeSum {

    // two pointer approach
    // -1,0,1,2,-1,-4
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums); // -4, -1, -1, 0, 1, 2

        List<List<Integer>> result = new ArrayList<>();

        int currIndex = 0;
        int leftIndex = 1;
        int rightIndex = nums.length - 1;
        int sum = 0;

        while (currIndex < nums.length - 2) {

            sum = nums[currIndex] + nums[leftIndex] + nums[rightIndex];

            if (sum == 0) {

                List<Integer> list = List.of(nums[currIndex], nums[leftIndex], nums[rightIndex]);

                if (!result.contains(list)) {

                    result.add(list);
                }

                leftIndex++;
            } else if (sum < 0) {

                leftIndex++;

            } else {

                rightIndex--;
            }

            if (leftIndex >= rightIndex) {

                currIndex++;
                leftIndex = currIndex + 1;
                rightIndex = nums.length - 1;
            }
        }

        return result;
    }

    public static List<List<Integer>> threeSum1(int[] nums) {

        Arrays.sort(nums); // -4, -1, -1, 0, 1, 2

        List<List<Integer>> result = new ArrayList<>();

        for (int currIndex = 0; currIndex < nums.length - 2; currIndex++) {

            // skip repeated numbers
            if (currIndex > 0 && nums[currIndex] == nums[currIndex - 1]) {

                continue;
            }

            int leftIndex = 1;
            int rightIndex = nums.length - 1;

            while (leftIndex < rightIndex) {

                int sum = nums[currIndex] + nums[leftIndex] + nums[rightIndex];

                if (sum == 0) { // found the triplet

                    result.add(Arrays.asList(nums[currIndex], nums[leftIndex], nums[rightIndex]));

                    // Step 4: Move left to next different numbers
                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex + 1]) {

                        leftIndex++;
                    }

                    // Step 4: Move right to next different numbers
                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex - 1]) {

                        rightIndex--;
                    }
                } else if (sum < 0) {

                    leftIndex++;
                } else {

                    rightIndex++;
                }

            }
        }

        return result;
    }


    public static void main(String[] args) {

        int[] nums = {0, 0, 0};

        List<List<Integer>> lists = threeSum(nums);

        System.out.println(lists);

    }

}

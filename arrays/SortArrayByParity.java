package arrays;
/*
Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.

Return any array that satisfies this condition.

Example 1:
Input: nums = [3,1,2,4]
Output: [2,4,3,1]
Explanation: The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

Example 2:
Input: nums = [0]
Output: [0]
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class SortArrayByParity {

    private static int[] sortArrayByParity(int[] nums) {

        int[] result = new int[nums.length];

        int currentIndex = 0;
        int forwardIndex = 0;
        int backwardIndex = nums.length - 1;

        while (currentIndex < nums.length) {

            if (nums[currentIndex] % 2 == 0) {

                result[forwardIndex] = nums[currentIndex];
                forwardIndex++;
            } else {

                result[backwardIndex] = nums[currentIndex];
                backwardIndex--;
            }


            currentIndex++;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 4};

        int[] result = sortArrayByParity(nums);

        System.out.println(Arrays.toString(result));
    }
}

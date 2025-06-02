package arrays;
/*
Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]
*/

import java.lang.reflect.Array;
import java.util.Arrays;

public class MoveZeroes {

    private static void moveZeroes(int[] nums) {

        // 0,1,0,3,12

        int insertPos = 0;

        // Step 1: Move all non-zero elements to the front
        for (int num : nums) {

            if (num != 0) {

                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {

            nums[insertPos++] = 0;
        }
    }

    private static void moveZeroes2(int[] nums) {

        // 0,1,0,3,12

        int left = 0;
        int right = 0;

        while (left < nums.length && right < nums.length - 1) {

            right++;

            if (nums[left] == 0) {

                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] != 0) {
                left++;
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12, 0, 7};

        moveZeroes(arr);

        System.out.println(Arrays.toString(arr));

    }

}

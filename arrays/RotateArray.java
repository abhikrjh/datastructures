package arrays;
/*

Given an integer array nums, rotate the array to the right by k steps,
where k is non-negative.
Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
*/

import java.util.Arrays;

public class RotateArray {

    // Brute Force approach

    // 1,2,3,4,5,6

    private static void rightRotate1(int[] nums, int k) {

        for (int i = 0; i < k; i++) {

            int temp = nums[nums.length - 1];

            for (int j = nums.length - 2; j >= 0; j--) {

                nums[j + 1] = nums[j];
            }
            nums[0] = temp;

        }

        System.out.println(Arrays.toString(nums));
    }

    private static void leftRotate(int[] nums, int k) {

        for (int i = 0; i < k; i++) {

            int temp = nums[0];

            for (int j = 1; j < nums.length; j++) {

                nums[j - 1] = nums[j];
            }

            nums[nums.length - 1] = temp;
        }

        System.out.println(Arrays.toString(nums));
    }


    /*
    Optimized approach
    k = 2

    arr = [1, 2, 3, 4, 5, 6]

    6, 5, 4, 3, 2, 1  // reversed the whole array

    5, 6, 4, 3, 2, 1  // reversed the first k element of array

    5, 6, 1, 2, 3, 4 // reversed the remaining element of array
    */

    private static void rightRotate(int[] nums, int k) {

        if (nums.length == 0 || nums.length == 1) {
            return;
        }

        k = k % nums.length;

        System.out.println(k);

        // reverse the whole array
        reverseArray(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));

        // reverse first k element of array
        reverseArray(nums, 0, k - 1);

        System.out.println(Arrays.toString(nums));

        // reverse remaining element of array
        reverseArray(nums, k, nums.length - 1);


        System.out.println(Arrays.toString(nums));

    }

    private static void reverseArray(int[] arr, int start, int end) {

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

//        System.out.println(Arrays.toString(arr));
    }


    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] arr = {1, 2};
        int k = 5;

//        rightRotate(arr, k);

//        leftRotate(arr, k);

        rightRotate(arr, k);

//        System.out.println(Arrays.toString(arr));

    }
}

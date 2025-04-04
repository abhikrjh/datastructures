package blind75;
/*
Given an integer array nums, return an array answer such that answer[i] is equal to
the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
*/

import java.util.Arrays;

public class ProductOfArray {

/*

    // 1, 2, 3, 4

    // 1, 1, 2, 6 - prefix product(left side product except that index number)
    // 24, 12, 4, 1 - postfix product (right side product except that index number)


    // final answer would be

    // 24, 12, 8, 6

    How Did This Work?

    Prefix stored left-side product.

    Suffix multiplied it with right-side product.

    Each element now contains the product of all numbers except itself.
*/

    private static int[] productExceptSelf(int[] nums) {

        // 1, 2, 3, 4
        // 1, 1, 2, 6
        // 24, 12, 4, 1

        int[] prefixProduct = new int[nums.length];
        int[] postfixProduct = new int[nums.length];

        int[] finalProduct = new int[nums.length];

        prefixProduct[0] = 1;

        for (int i = 1; i < nums.length; i++) {

            prefixProduct[i] = prefixProduct[i - 1] * nums[i - 1];
        }

        System.out.println(Arrays.toString(prefixProduct));

        postfixProduct[nums.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {

            postfixProduct[i] = postfixProduct[i + 1] * nums[i + 1];
        }

        System.out.println(Arrays.toString(postfixProduct));

        for (int i = 0; i < nums.length; i++) {

            finalProduct[i] = prefixProduct[i] * postfixProduct[i];
        }

        return finalProduct;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4};
        int[] productList = productExceptSelf(nums);

        System.out.println(Arrays.toString(productList));
    }
}

package blind75;

/*

Given an integer array nums, find a subarray that has the largest product, and return the product.

Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray
*/

/*
Approach :

We need to used a dynamic tracking method — at every index, we keep track of:

currMax → the maximum product ending at current index

currMin → the minimum product ending at current index (important because a negative times a negative becomes positive)
*/


public class MaximumProductSubArray {

    private static int maxProduct(int[] nums) {
        // 2,3,-2,4
        // 2, 3 = 6

        // Step 1: Start with the first number
        int maxProduct = nums[0];

        // Step 2: Create two variables:
        // - currMax: max product ending at current index
        // - currMin: min product ending at current index
        int currMax = nums[0];
        int currMin = nums[0];

        // Step 3: Start checking from second number

        for (int i = 1; i < nums.length; i++) {

//            2,3,-2,-4

            int currentNumber = nums[i];

            // Step 4: If current number is negative, swap currMax and currMin
            // Because multiplying with a negative flips max ↔ min

            if (currentNumber < 0) {

                int temp = currMax;
                currMax = currMin;
                currMin = temp;
            }

            // Step 5: Update currMax and currMin

            int tempMax = currMax;
            int tempMin = currMin;

            currMax = Math.max(currentNumber, Math.max(tempMax * currentNumber, tempMin * currentNumber));
            currMin = Math.min(currentNumber, Math.min(tempMax * currentNumber, tempMin * currentNumber));


            System.out.println("currMax : " + currMax + " , currMin : " + currMin);

            // Step 6: Update overall maxProduct
            maxProduct = Math.max(maxProduct, currMax);

        }

        return maxProduct;
    }

    public static void main(String[] args) {

        int[] nums = {2, 3, -2, -4};

        int maxProduct = maxProduct(nums);

        System.out.println(maxProduct);
    }
}

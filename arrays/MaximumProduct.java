package arrays;
/*
Given the array of integers nums, you will choose two different indices i and j of that array.
Return the maximum value of (nums[i]-1)*(nums[j]-1).

Example 1:

Input: nums = [3,4,5,2]
Output: 12
Explanation: If you choose the indices i=1 and j=2 (indexed from 0),
you will get the maximum value, that is, (nums[1]-1)*(nums[2]-1) = (4-1)*(5-1) = 3*4 = 12.
Example 2:

Input: nums = [1,5,4,5]
Output: 16
Explanation: Choosing the indices i=1 and j=3 (indexed from 0),
you will get the maximum value of (5-1)*(5-1) = 16.
Example 3:

Input: nums = [3,7]
Output: 12
*/

public class MaximumProduct {

    public static int maxProduct(int[] nums) {

        // find largest and second largest and then multiply
        int max1 = 0;
        int max2 = 0;
        for(int i=0; i< nums.length; i++) {
            // 3,4,5,2
            if(max1 < nums[i]) {
                max2 = max1;
                max1 = nums[i];
            } else {

                if(max2 < nums[i]) {
                    max2 = nums[i];
                }
            }

        }
        int val1 = max1-1;
        int val2 = max2-1;

        System.out.println(val1*val2);

        return val1*val2;
    }

    public static void main(String[] args) {
        int[] nums = {3,4,5,2};

        maxProduct(nums);
    }
}

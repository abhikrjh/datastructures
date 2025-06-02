package arrays;
/*
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

Since the result may be very large, so you need to return a string instead of an integer.

Example 1:

Input: nums = [10,2]
Output: "210"
Example 2:

Input: nums = [3,30,34,5,9]
Output: "9534330"

*/

import java.util.Arrays;

public class LargestNumber {

    /*
    Input: nums = [3,30,34,5,9]
    Output: "9534330"
    */

    public static String largestNumber(int[] nums) {

        // convert Integer to String

        String[] strNums = new String[nums.length];

        for(int i=0; i< nums.length; i++) {

            strNums[i] = String.valueOf(nums[i]);
        }

        System.out.println(Arrays.toString(strNums));

        // Sort strings using custom comparators

        Arrays.sort(strNums, (a, b) -> (b+a).compareTo(a+b));

        System.out.println(Arrays.toString(strNums));

        if (Arrays.stream(strNums).allMatch(s -> s.equals("0")))
            return "0";

        StringBuilder sb = new StringBuilder();

        for (String str : strNums) {

             sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{3,30,34,0, 5,9};

        int[] nums = new int[]{0, 1};
        String s = largestNumber(nums);

        System.out.println(s);
    }
}

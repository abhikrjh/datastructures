package arrays;

import java.util.Arrays;
import java.util.Comparator;

import static java.util.Arrays.stream;

/*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.

Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.

Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
*/

public class ThirdMaximumNumber {


    private static int thirdMax(int[] nums) {

        int skipLimit = 0;

        // 1, 2, 3, 4, 5 // 5 - 3 = 2
        // 1, 2, 3, 4, 5, 6, 7, 8 = 8 - 3 = 5

        // 1, 2 = 2
        // 1, 2, 3 =

        long count = stream(nums)
                .distinct().count();

        if(count > 3){
            skipLimit = (int) (count - 3);
        } else if (count == 3) {
            skipLimit = 0;
        } else {
            skipLimit = (int) (count - 1);
        }

        System.out.println(skipLimit);

        return Arrays.stream(nums)
                .sorted()
                .distinct()
                .skip(skipLimit)
                .findFirst()
                .orElse(-1);
    }


    public static void main(String[] args) {

        int[] nums = {2,1};

        int thirdMax = thirdMax(nums);

        System.out.println(thirdMax);
    }
}

package binarysearch;

//Given an array of integres nums sorted in ascending order,
//find the starting and end position of given target value, if target is not found then return [-1,-1]

import java.util.Arrays;

//Input nums = [5,7,7,8,8,10]
//    traget = 8, o/p = [3,4]
//    target = 6, o/p = [-1,-1]
public class FirstAndLastPosition {


    private static int findIndex(int[] nums, int target, boolean findStartIndex) {

        int position = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                position = mid;
                if (findStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

        }
        return position;
    }


    private static int[] findFirstAndLastPosition(int[] nums, int target) {

        int[] ans = {-1, -1};
        int firstIndex = findIndex(nums, target, true);

        int endIndex = findIndex(nums, target, false);

        ans[0] = firstIndex;
        ans[1] = endIndex;
        return ans;
    }


    public static void main(String[] args) {

        int[] nums = new int[]{5, 7, 7, 8, 8, 8, 10};
        int target = 7;

        int[] index = findFirstAndLastPosition(nums, target);

        System.out.println(Arrays.toString(index));
    }
}

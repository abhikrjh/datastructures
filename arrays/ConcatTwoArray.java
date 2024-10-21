package arrays;

//DAY : 1

//Given an integer array nums of length n,
// you want to create an array ans of length 2n
// where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
//Specifically, ans is the concatenation of two nums arrays.
//Return the array ans.


//nums = [0,1,2,3,4]   length = n
//ans = [0,1,2,3,4,-,-,-,-,-] length = 2n


import java.util.Arrays;

public class ConcatTwoArray {


    private static int[] concatTwoArray(int[] nums, int n){

        int[] ans = new int[2*n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i+n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,3,4};
        int n = nums.length;
        System.out.println(Arrays.toString(concatTwoArray(nums, n)));
        System.out.println(n);
    }
}

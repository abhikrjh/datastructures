package arrays;

//DAY :2

// Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
// Return the array in the form [x1,y1,x2,y2,...,xn,yn].

//HINT : Think to place element at even and odd places

//0,1,2,3,4,5
//0,3,1,4,2,5

import java.util.Arrays;
public class ShuffleTheArray {

    private static int[] shuffleArray(int[] nums){
        int n = nums.length;

        int[] ans = new int[n];

        for (int i = 0; i < n/2; i++) {
            ans[2*i] = nums[i];
            ans[2*i+1] = nums[n/2+i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{0,1,2,3,4,5};
        System.out.println(Arrays.toString(shuffleArray(nums)));
    }

}

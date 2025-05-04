package arrays;
/*
Given an array of N integers, left rotate the array by one place.

Input:
N = 5, array[] = {1,2,3,4,5}

Output:
2,3,4,5,1
*/

import java.util.Arrays;

public class LeftRotateArray {


    private static int[] leftRotateArrayByOnePlace(int[] arr) {

        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {

            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

    private static int[] leftRotate(int[] arr, int k){

        k = k % arr.length; // this is important when k is more than arr length
        // otherwise when its less it will not change value of k

        // reverse the entire array

        reverseArr(arr, 0, arr.length - 1);

        // reverse the right most k element

        reverseArr(arr, arr.length - k, arr.length - 1);

        // reverse the remaining left element

        return reverseArr(arr, 0, arr.length - (k + 1));
    }


    private static int[] reverseArr(int[] arr, int start, int end){

        while(start < end){

            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }

        return arr;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};
        int k = 3;

//        System.out.println(Arrays.toString(leftRotateArrayByOnePlace(arr)));

        // 5, 4, 3, 2, 1 - 1st step (reversed the entire array)
        // 5, 4, 1, 2, 3 - 2nd step (reversed the right most k(3) element (3, 2, 1 became 1, 2, 3))
        // 4, 5, 1, 2, 3 - 3rd step (reversed the remaining left element) (5, 4 became 4, 5)

        System.out.println( Arrays.toString(leftRotate(arr, k)));
    }
}

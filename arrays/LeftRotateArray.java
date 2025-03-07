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

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(leftRotateArrayByOnePlace(arr)));
    }
}

package arrays;/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.

Input:
arr = [-2,1,-3,4,-1,2,1,-5,4]

Output: 6
*/

public class KadanesAlgorithm {


    private static int largestContiguousSum(int[] arr) {

        int maxContigiousSum = Integer.MIN_VALUE;
        int sum = 0;
        int i = 0;

        while (i < arr.length) {

            sum += arr[i];

           if (sum > maxContigiousSum){
               maxContigiousSum = sum;
           }

           if(sum < 0){
               sum = 0;
           }

            i++;
        }
        return maxContigiousSum;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println(largestContiguousSum(arr));
    }
}

package arrays;


/*
Given an array, and an element num the task is to find if num is present in the given array or not.
If present print the index of the element or print -1.
*/

public class LinearSearch {

    private static int linearSearch(int[] arr, int num) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4, 8, 9, 2, -1};

        System.out.println(linearSearch(arr, 9));
    }
}

package arrays;


/*
Given an array of size n, write a program to check,
 if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not.
If the array is sorted then return True, Else return False.
*/


public class ArrayIsSorted {

    private static boolean isSortedInAscendingOrder(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean isSortedInDescendingOrder(int[] arr) {

        if (arr.length == 0 || arr.length == 1) {
            return true;
        }

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{1, 3, 4, 8, 9, 10, 12};
//      int[] arr = new int[]{10, 9, 8, 6, 3, 2, 1};

        System.out.println(isSortedInDescendingOrder(arr));
        System.out.println(isSortedInAscendingOrder(arr));
    }
}

package arrays;

/*
Given an unsorted array of size n. Array elements are in the range of 1 to n.
One number from set {1, 2, …n} is missing and one number occurs twice in the array.
The task is to find these two numbers.

Examples:

Input: arr[] = {3, 1, 3}
Output: 3, 2
Explanation: In the array, 2 is missing and 3 occurs twice.


Input: arr[] = {4, 3, 6, 2, 1, 1}
Output: 1, 5
Explanation: 5 is missing and 1 is repeating.
*/

import java.util.*;

public class MissingAndRepeatingNumber {

    private static List<Integer> missingAndRepeatingNumber(int[] arr) {

        List<Integer> list = new ArrayList<>();

        int repeatingNumber = 0;

        int len = arr.length;

        Set<Integer> s = new HashSet<>();

        repeatingNumber = repeatingNumber(arr, len, s, repeatingNumber, list);

        // Identify the missing number

        //missingNumber(arr, len, repeatingNumber, list);
        list.add(missingNumber(s, len));

        return list;
    }

    private static int repeatingNumber(int[] arr, int len, Set<Integer> s, int repeatingNumber, List<Integer> list) {

        // Identify the repeating number
        for (int i = 0; i < len; i++) {

            if (s.contains(arr[i])) {

                repeatingNumber = arr[i];
                list.add(arr[i]);
            } else {

                s.add(arr[i]);
            }
        }
        return repeatingNumber;
    }

    private static void missingNumber(int[] arr, int len, int repeatingNumber, List<Integer> list) {

        int expectedSum = len * (len + 1) / 2;
        int actualSum = 0;

        for (int i = 0; i < len; i++) {

            actualSum += arr[i];
        }

        int sumWithOutRepeatingNumber = actualSum - repeatingNumber;

        // missing number
        list.add(expectedSum - sumWithOutRepeatingNumber);
    }

    private static int missingNumber(Set<Integer> s, int len) {

        for (int i = 1; i <= len; i++) {

            if (!s.contains(i)) {

                return i;
            }
        }
       return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        List<Integer> list = missingAndRepeatingNumber(arr);

        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}

package binarysearch;

public class CeilingOfANumber {

    // return smallest number which is >= target

//    Ceiling means "greater than OR EQUAL TO", not strictly greater.
//
//    If target exists, it itself is the ceiling.

    private static int ceilingOfANumber(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (startIndex <= endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (target < arr[middleIndex]) {
                endIndex = middleIndex - 1;
            } else if (target > arr[middleIndex]) {
                startIndex = middleIndex + 1;
            } else {
                return arr[middleIndex];
            }
        }
        return arr[startIndex];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 7, 9, 14, 16, 19};
        int target = 8;

        int i = ceilingOfANumber(arr, target);

        System.out.println("ceiling of " + target + " is : " + i);
    }
}

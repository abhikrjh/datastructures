package binarysearch;

public class FloorOfANumber {

    // return greatest number which is <= target
    private static int ceilingOfANumber(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        if (target > arr[arr.length - 1]) {
            return -1;
        }

        while (start <= end) {

            int mId = start + (end - start) / 2;

            if (target < arr[mId]) {
                end = mId - 1;
            } else if (target > arr[mId]) {
                start = mId + 1;
            } else {
                return arr[mId];
            }
        }
        return arr[end];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 6, 7, 14, 16, 19};
        int target = 8;

        int i = ceilingOfANumber(arr, target);

        System.out.println("ceiling of " + target + " is : " + i);
    }
}

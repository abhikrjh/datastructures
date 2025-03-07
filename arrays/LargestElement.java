package arrays;

//Given an array, we have to find the largest element in the array.

public class LargestElement {

    private static int largestNumber(int[] arr) {

        int largestNum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (largestNum < arr[i]) {
                largestNum = arr[i];
            }
        }
        return largestNum;
    }


    public static void main(String[] args) {

        int[] arr = new int[]{7, 3, 4, 8, 9, 0, -1, 4, 5};

        System.out.println(largestNumber(arr));
    }
}

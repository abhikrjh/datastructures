package arrays;

/*
Given an array, find the second smallest and second largest element in the array.
        Print ‘-1’ in the event that either of them doesn’t exist.
*/

public class SecondLargestElement {

    private static int secondLargest(int[] arr) {

        int secondLargest = Integer.MIN_VALUE;
        int largest = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > largest) {

                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] > secondLargest && arr[i] != largest) {

                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }

    private static int secondSmallest(int[] arr) {

        int secondSmallest = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < smallest) {

                secondSmallest = smallest;
                smallest = arr[i];

            } else if (arr[i] < secondSmallest && arr[i] != smallest) {

                secondSmallest = arr[i];
            }
        }
        return secondSmallest;
    }

    public static void main(String[] args) {

        int[] arr = new int[]{7, 1, 5, 3, 6, 4, 8, 9, 2, -1};
        System.out.println(secondLargest(arr));
        System.out.println(secondSmallest(arr));
    }
}

package recursion;

public class BinarySearchUsingRecursion {

    static int binarySearch(int[] arr, int target, int start, int end) {

        int mid = start + (end - start) / 2;

        if (start > end) {
            return -1;
        }

        if (target == arr[mid]) {
            return mid;
        }

        if (target > arr[mid]) {

            return binarySearch(arr, target, mid + 1, end);
        }

        return binarySearch(arr, target, start, mid - 1);
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 9, 12, 16, 17, 26, 27, 36};

        int target = 16;

        int searchedIndex = binarySearch(arr, target, 0, arr.length - 1);
        System.out.println(searchedIndex);
    }
}

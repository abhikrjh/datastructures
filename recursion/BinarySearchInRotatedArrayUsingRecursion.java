package recursion;


// Input arr = [5, 6, 0 , 1, 2, 3] , target = 6

// Input arr = [1, 2, 3, 0, 6, 5] target = 6


public class BinarySearchInRotatedArrayUsingRecursion {

    static int rotatedBinarySearchUsingRecursion(int[] arr, int target, int start, int end) {

        int mid = start + (end - start) / 2;

        if (target == arr[mid]) {
            return mid;
        }
       // Defining range of search here
        // Search would be in left part of array

        if (arr[start] <= arr[mid]) {

            if (target >= arr[start] && target <= arr[mid]) {

                return rotatedBinarySearchUsingRecursion(arr, target, 0, mid - 1);
            } else {

                return rotatedBinarySearchUsingRecursion(arr, target, mid + 1, end);
            }
        }

        // below part is the  else of first if
        // Search would be in right side of array

        if (target >= arr[mid]) {
            return rotatedBinarySearchUsingRecursion(arr, target, mid + 1, end);
        }
        return rotatedBinarySearchUsingRecursion(arr, target, start, mid - 1);
    }

    static int rotatedBinarySearch(int[] arr, int target) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (target == arr[mid]) {
                return mid;
            }

            if (arr[start] <= arr[mid]) {

                if (target >= arr[start] && target <= arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            if (target >= arr[mid] && target <= arr[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {5, 6, 1, 2, 3, 4};
        int target = 4;

//        int searchedIndex = rotatedBinarySearch(arr, target);
//
//        System.out.println(searchedIndex);

        int searchedIndex = rotatedBinarySearchUsingRecursion(arr, target, 0 , arr.length-1);

        System.out.println(searchedIndex);
    }

}

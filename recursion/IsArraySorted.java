package recursion;

public class IsArraySorted {

    static boolean isSorted(int[] arr) {
        return helper(arr, 0); // started with 0 and will keep increasing this if arr[index] < arr[index+1]
    }

    private static boolean helper(int[] arr, int index) {

        if (index == arr.length - 1) {
            return true;
        }

        if (arr[index] < arr[index + 1]) {
            return helper(arr, index + 1);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 7, 8};

        boolean sorted = isSorted(arr);

        System.out.println(sorted);
    }

}

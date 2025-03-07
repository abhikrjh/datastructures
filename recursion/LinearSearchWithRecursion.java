package recursion;

// find the element in the given array
// arr = [ 3,2,1,18,9] and target = 18

public class LinearSearchWithRecursion {

    static int searchIndex(int[] arr, int target) {

        return helper(arr, target, 0);
    }

    private static int helper(int[] arr, int target, int index) {

        // Base condition or termination condition(both if)

        if (arr.length == 0 || index == arr.length) {
            return -1;
        }

        if (arr[index] == target) {
            return index;
        }

        return helper(arr, target, index + 1);
    }

    public static void main(String[] args) {

        int[] arr = {3, 2, 1, 18, 9};
        int target = 9;

        int search = searchIndex(arr, target);

        System.out.println(search);
    }

}

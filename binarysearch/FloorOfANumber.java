package binarysearch;

public class FloorOfANumber {

    // return greatest number which is <= target

    // "The greatest number that is less than OR EQUAL TO the target."

   //  If an exact match for the target exists, the floor is the target itself.
    //  Otherwise, it is the largest number smaller than the target.

    private static int floorOfANumber(int[] arr, int target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        if(target < arr[0]){
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
        return arr[endIndex];
    }

    public static void main(String[] args) {

        int[] arr = new int[]{3, 5, 6, 7, 14, 16, 19};
        int target = 2;

        int i = floorOfANumber(arr, target);

        System.out.println("ceiling of " + target + " is : " + i);
    }
}

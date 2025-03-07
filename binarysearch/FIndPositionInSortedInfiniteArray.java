package binarysearch;

//Find position of an element in a sorted infinite array

public class FIndPositionInSortedInfiniteArray {


    private static int findAns(int[] arr, int target){

        // arr = [2,3,5,6,7,9,10,11,14,17,20,22,24,27]

        int start = 0;
        int end = 1;

        while(arr[end] < target){

            int newStart = end + 1;
            //  double the range of start and end index
            end = end + (end - start + 1) * 2;
            start = newStart;
        }
        return findPosition(arr, target, start, end);
    }


    private static int findPosition(int[] arr, int target, int start, int end){

            while (start <= end) {

                int mid = start + (end - start) / 2;

                if (target < arr[mid]) {

                    end = mid - 1;
                } else if (target > arr[mid]) {

                    start = mid + 1;
                } else {

                    return mid;
                }
            }
            return -1;
        }


    public static void main(String[] args) {

        int[] arr = {2,3,5,6,7,9,10,11,14,17,20,22,24,27};
        int ans = findAns(arr, 27);

        System.out.println(ans);
    }
}

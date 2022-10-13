package arrays;

public class MaximumSubArray {

//    Given an integer array numbs, find the contiguous sub array (containing at least one number)
//    which has the largest sum and return its sum.
//    Input: numbs = [-2,1,-3,4,-1,2,1,-5,4]
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.

    public int largestContiguousSubArraySum(int[] array) {
        // -2,1,-3,4,-1,2,1,-5,4
        int largestSum = Integer.MIN_VALUE;
        int maxUptoHere = 0;
        int startIndex = 0; int endIndex = 0;
        for (int i = 0; i < array.length; i++) {
            maxUptoHere += array[i];
            if (largestSum < maxUptoHere) {
                largestSum = maxUptoHere;
                endIndex = i;
            }
            if (maxUptoHere<0){
                startIndex = i+1;
                maxUptoHere = 0;
            }
        }
        System.out.println("start index = "+startIndex+" end index = "+ endIndex);
        return largestSum;
    }

    public static void main(String[] args) {
        MaximumSubArray m = new MaximumSubArray();
        int[] array = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(m.largestContiguousSubArraySum(array));
    }


}

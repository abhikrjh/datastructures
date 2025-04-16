package blind75;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
        Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
        Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.

*/

/*
✅ Why This Works (How did it work?)
This uses binary search to find the smallest value in a rotated sorted array.

If nums[mid] > nums[end], that means the smallest value must be after mid.

        Else, the smallest is in the left half (including mid).

Eventually, start and end will converge to the index of the minimum element.

🧪 Example:
For input: [4,5,6,7,0,1,2]

Initially: start = 0, end = 6, mid = 3 → nums[mid] = 7

Since 7 > 2, search in right → start = 4

Now start = 4, end = 6, mid = 5 → nums[mid] = 1

Since 1 < 2, move end = 5

Now start = 4, end = 5, mid = 4 → nums[mid] = 0

Since 0 < 1, move end = 4

start == end == 4, nums[4] = 0 → ✅ This is the answer!
*/



public class MinInRotatedSortedArray {

    // We must write an algorithm that runs in O(log n) time.
    // Apply binary search beacuse we need to write it in O(log n) times

    // 0,1,2,4,5,6,7
    // 4,5,6,7,0,1,2 - 4 times

    private static int findMin(int[] nums) {

        int start = 0;
        int end = nums.length - 1;

        while (start < end) {

            int mid = start + (end - start) / 2;

//            int[] nums = {0,1,2,4,5,6,7};

            if (nums[mid] < nums[end]) {

                end = mid;
            } else if (nums[mid] > nums[end]) {

                // 4,5,6,7,0,1,2

                start = mid + 1;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {

        int[] nums = {4,5,6,7,0,1,2};

        int min = findMin(nums);

        System.out.println(min);
    }
}

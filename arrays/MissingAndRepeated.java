package arrays;

/*
You are given a 0-indexed 2D integer matrix grid of size n * n with values in the range [1, n2]. Each integer appears exactly once except a which appears twice and b which is missing. The task is to find the repeating and missing numbers a and b.

Return a 0-indexed integer array ans of size 2 where ans[0] equals to a and ans[1] equals to b.

Example 1:

Input: grid = [[1,3],[2,2]]
Output: [2,4]
Explanation: Number 2 is repeated and number 4 is missing so the answer is [2,4].
Example 2:

Input: grid = [[9,1,7],[8,9,2],[3,4,6]]
Output: [9,5]
Explanation: Number 9 is repeated and number 5 is missing so the answer is [9,5].
*/

import java.util.*;
import java.util.stream.IntStream;

public class MissingAndRepeated {

    private static int[] findMissingAndRepeatedValues(int[][] grid) {

        int[] sortedArray = Arrays.stream(grid)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .toArray();

        Set<Integer> set = new HashSet<>();

        int duplicate = Arrays.stream(sortedArray)
                .filter(e -> !set.add(e))
                .findFirst()
                .getAsInt();

        System.out.println(Arrays.toString(sortedArray));

        int[] uniqueArray = Arrays.stream(sortedArray).distinct().toArray();

        long n = Arrays.stream(sortedArray).count();

        int expectedSum = (int) (n * (n + 1) / 2);
        int actualSum = Arrays.stream(uniqueArray).sum();

        int missingNumber = expectedSum - actualSum;

        System.out.println(duplicate);
        System.out.println(missingNumber);

        return new int[]{duplicate, missingNumber};
    }

    public static void main(String[] args) {

//        int[][] grid = {{9, 1, 7}, {8, 9, 2}, {3, 4, 6}};

        int[][] grid = {{1,3}, {2,2}};
        int[] missingAndRepeatedValues = findMissingAndRepeatedValues(grid);

        System.out.println(Arrays.toString(missingAndRepeatedValues));
    }
}

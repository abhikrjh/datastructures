package binarysearch;

/*
        You are given an array of characters letters that is sorted in non-decreasing order,
        and a character target. There are at least two different characters in letters.

        Return the smallest character in letters that is lexicographically greater than target.
        If such a character does not exist, return the first character in letters.

        Example 1:

        Input: letters = ["c","f","j"], target = "a"
        Output: "c"
        Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.
                Example 2:

        Input: letters = ["c","f","j"], target = "c"
        Output: "f"
        Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.
                Example 3:

        Input: letters = ["x","x","y","y"], target = "z"
        Output: "x"
        Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].
        */

public class SmallestLetterGreaterThanTarget {


    private static char smallestLetterGreaterThanTarget(char[] arr, char target) {

        int startIndex = 0;
        int endIndex = arr.length - 1;

        if (arr.length == 0) {
            return '-';
        }

        if (target >= arr[endIndex]) {

            return arr[startIndex];
        }

        while (startIndex <= endIndex) {

            int middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (target < arr[middleIndex]) {

                endIndex = middleIndex - 1;
            } else {

                startIndex = middleIndex + 1;
            }
        }
        return arr[startIndex];
    }


    public static void main(String[] args) {

        //char[] arr = new char[] {'c', 'f', 'j'};

        char[] arr = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};

        char target = 'e';

        char smallestLetterGreaterThanTarget = smallestLetterGreaterThanTarget(arr, target);
        System.out.println(smallestLetterGreaterThanTarget);
    }


}

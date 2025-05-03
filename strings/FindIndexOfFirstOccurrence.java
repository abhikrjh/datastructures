package strings;

/*
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack,
or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
*/


public class FindIndexOfFirstOccurrence {

    private static int strStr(String haystack, String needle) {

        int hLength = haystack.length();
        int nLength = needle.length();

        if (nLength == 0)
            return -1;

        /*
        If haystack.length() = 9 and needle.length() = 3, the last valid starting index is:
        9-3=6
        So, valid i values: 0 to 6
        */

        for (int i = 0; i <= hLength - nLength; i++) {

            if (haystack.substring(i, i + nLength).equals(needle)) {   // Extracts a substring of length equal to needle starting at index i.
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";

        System.out.println(strStr(haystack, needle));
    }
}
package strings;

import java.util.Arrays;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:
Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

*/
public class LongestCommonPrefix {

    private static String longestCommonPrefix(String[] strs) {

        if (null == strs || strs.length == 0) {

            return "";
        }

        // lexicographically(dictionary order) sorted the strings flight, flow, flower
        Arrays.sort(strs);

        int i = 0;

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        boolean matching = true;

        while (i < first.length && i < last.length && (first[i] == last[i])) {

            i++;
        }

        return String.valueOf(first).substring(0, i);
    }

    public static void main(String[] args) {
        String[] strs = {""};

        System.out.println(longestCommonPrefix(strs));
    }
}

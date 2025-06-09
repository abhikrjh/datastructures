package strings;

/*
Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Example 1:

Input: s = "IceCreAm"
Output: "AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A']. On reversing the vowels, s becomes "AceCreIm".

Example 2:
Input: s = "leetcode"
Output: "leotcede"
*/

import java.util.List;

public class ReverseVowelsOfString {

    private static String reverseVowels(String s) {

        List<Character> list = List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] chars = s.toCharArray();

        int start = 0;
        int end = chars.length - 1;

        while(start < end) {

            if(!list.contains(chars[start])) {

                start++;
            }

            if(!list.contains(chars[end])) {

                end--;
            }

            if(list.contains(chars[start]) && list.contains(chars[end])) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;

                start++;
                end--;
            }

        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {

        String s = "IceCreAm";

        String s1 = reverseVowels(s);

        System.out.println(s1);
    }
}

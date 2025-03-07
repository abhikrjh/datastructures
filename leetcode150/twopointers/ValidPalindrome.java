package leetcode150.twopointers;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and
removing all non-alphanumeric characters, it reads the same forward and backward.
Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
*/

public class ValidPalindrome {

    private static boolean isPalindrome(String s) {

        if (s.isEmpty()) {
            return true;
        }

        s = removeNonAlphaNumericChar(s).toLowerCase();

        System.out.println(s);

        char[] charArr = s.toCharArray();

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {

            if (charArr[start] != charArr[end]) {
                return false;
            }

            start++;
            end--;
        }
        return true;
    }

    private static String removeNonAlphaNumericChar(String s) {

        return s.replaceAll("[^a-zA-Z0-9]", "");
    }

    public static void main(String[] args) {

        String s = "A man, a plan, a canal: Panama";

        System.out.println(isPalindrome(s));
    }

}

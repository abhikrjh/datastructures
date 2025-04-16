package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Given a string S. The task is to find the length of the longest substring
        without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

*/
public class LongestContigiousString {


    public static int lengthOfLongestSubstring(String s) {

        if (s.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            if (map.get(currentChar) != null) {

                left = Math.max(left, map.get(currentChar) + 1);
            }

            map.put(currentChar, right);

            // calculate the max length

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static String longestNonRepeatingSubstring(String s) {

        if (s.isEmpty())
            return "";

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        String nonRepeatingCharString = "";

        for (int right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);

            if (map.get(currentChar) != null) {

                left = Math.max(left, map.get(currentChar) + 1);

                if (nonRepeatingCharString.length() < (right - left + 1)) {

                    nonRepeatingCharString = s.substring(left, right + 1);
                }
            }

            map.put(currentChar, right);
        }

        return nonRepeatingCharString;
    }


    public static int lengthOfLongestSubstring1(String s) {

        Map<String, Integer> map = new HashMap<>();

        char[] arr = s.toCharArray();
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (char c : arr) {

            if (map.get(c + "") == null) {
                map.put(c + "", 1);
                sb.append(c);
            } else {
                list.add(sb.toString());

                map = new HashMap<>();
                sb = new StringBuilder();


                map.put(c + "", 1);
                sb.append(c);
            }
        }

        int maxLengthString = 0;

        for (int i = 0; i < list.size(); i++) {

            String element = list.get(i);

            if (element.length() > maxLengthString) {

                maxLengthString = element.length();
            }
        }

        return maxLengthString;
    }


    public static void main(String[] args) {

        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));

        System.out.println(longestNonRepeatingSubstring(s));
    }
}

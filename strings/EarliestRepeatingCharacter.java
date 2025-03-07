package strings;
/*
Given a string S of length n, the task is to find the earliest repeated character in it.
The earliest repeated character means, the character that occurs more than once and whose second occurrence
has the smallest index.

Example:

Input: s = “geeksforgeeks”
Output: e
Explanation: e is the first element that repeats


Input: s = “hello geeks”
Output: l
Explanation: l is the first element that repeats
*/

import java.util.HashMap;
import java.util.Map;

public class EarliestRepeatingCharacter {

    private static String earliestRepeatingChar(String str) {

        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();

        for (int i = 0; i < charArray.length; i++) {

            char c = charArray[i];

            if (map.containsKey(c)) {

                return Character.toString(c);
            } else {

                map.put(c, i);
            }

        }
        return null;
    }

    public static void main(String[] args) {

        String s = "helo gekss";

        System.out.println(earliestRepeatingChar(s));
    }

}

package strings;

/*
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

Example 1:

Input: s = "leetcode"
Output: 0

Explanation:

The character 'l' at index 0 is the first character that does not occur at any other index.

Example 2:

Input: s = "loveleetcode"
Output: 2

Example 3:

Input: s = "aabb"
Output: -1
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    private static int firstUniqueChar(String s) {

        char[] chars = s.toCharArray();

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : chars) {

            if (map.get(c) == null) {

                map.put(c, 1);
            } else {

                map.put(c, map.get(c) + 1);
            }
        }

        Character key = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        if (null == key) {

            return -1;
        }

        for (int i = 0; i < chars.length; i++) {

            if (key.equals(chars[i])) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        String input = "aabb";

        int i = firstUniqueChar(input);

        System.out.println(i);
    }
}

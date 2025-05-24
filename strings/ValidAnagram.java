package strings;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class ValidAnagram {

    private static boolean isAnagram(String s, String t) {

        char[] chars1 = s.toCharArray();

        Map<Character, Integer> map1 = new LinkedHashMap<>();

        for (char c : chars1) {

            if (map1.get(c) == null) {

                map1.put(c, 1);
            } else {

                map1.put(c, map1.get(c) + 1);
            }
        }


        char[] chars2 = t.toCharArray();

        Map<Character, Integer> map2 = new LinkedHashMap<>();

        for (char c : chars2) {

            if (map2.get(c) == null) {

                map2.put(c, 1);
            } else {

                map2.put(c, map2.get(c) + 1);
            }
        }

        return map1.equals(map2);
    }

    public static void main(String[] args) {

        String s = "anagram";
        String t = "nagaram";

        boolean anagram = isAnagram(s, t);

        System.out.println(anagram);
    }
}

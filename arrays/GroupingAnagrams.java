package arrays;

/*
    1. Grouping the anagrams (anagram is a word created from the same set of letters)
    2. Sort the resulting list by the number of words in each sub-list.

    Input array: ["eat", "ate", "cat", "elbow", "below", "tea"]

    Output array: [["cat"], ["elbow", "below"], ["ate", "eat", "tea"]]
*/

import java.util.*;

public class GroupingAnagrams {

    public static void main(String[] args) {

        String[] inputStr = {"eat", "ate", "cat", "elbow", "below", "tea"};

        System.out.println(groupAnagrams(inputStr));
    }

    private static List<List<String>> groupAnagrams(String[] words) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : words) {

            char[] chars = word.toCharArray();

            Arrays.sort(chars); // sorted the character to generate the common key for anagram

            String sortedWords = new String(chars);

            map.putIfAbsent(sortedWords, new ArrayList<>());

            map.get(sortedWords).add(word);
        }

        System.out.println(map);

        return createSortList(map);
    }

    private static List<List<String>> createSortList(Map<String, List<String>> map) {

        return map.entrySet()
                .stream()
                .map(listEntry -> listEntry.getValue())
                .sorted(Comparator.comparing(List::size))
                .toList();
    }
}

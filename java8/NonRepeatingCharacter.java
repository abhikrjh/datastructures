package java8;

import java.util.LinkedHashMap;

import java.util.stream.Collectors;

//Find the First Non-Repeating Character in a String
public class NonRepeatingCharacter {

    private static Character firstNonRepeatingChar(String s) {

        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse('-');
    }

    // Statement: Given a string, find the first non-repeating character using Java 8 Streams.

    private static void firstNonRepeatingCharacter(String str) {

        Character firstNonRepeatingChar = str.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findFirst()
                .get()
                .getKey();

        System.out.println(firstNonRepeatingChar);
    }

    public static void main(String[] args) {
        String str = "swiss"; // o/p = w
        System.out.println(firstNonRepeatingChar(str));

        firstNonRepeatingCharacter(str);
    }
}

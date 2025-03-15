package java8;

//Given a list of words, find the longest word.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestWord {

    private static String longestWord(List<String> words){

        return words.stream()
                .max(Comparator.comparingInt(value -> value.length()))
                .orElse("");

    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "watermelon");

        System.out.println(longestWord(words));
    }
}

package java8;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Sort a list of strings based on their length.
public class SortStringBaseOnLength {

    private static List<String> sortList(List<String> words){

        return words.stream()
                .sorted(Comparator.comparing(s -> s.length()))
                .toList();
    }


    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "kiwi", "grape");

        System.out.println(sortList(words));
    }
}

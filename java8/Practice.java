package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice {

    // Transform a list of Strings into their lengths:

    private static void transform() {
        List<String> list = List.of("Test", "Java8", "Program");

        List<Integer> list1 = list.stream()
                .map(String::length)
                .toList();

        System.out.println(list1);
    }

    private static void flattenTheList() {
        List<String> list = Arrays.asList("Java", "AWS");

        System.out.println(Arrays.toString(list.getFirst().split("")));

        List<String> list1 = list.stream()
                .map(s -> s.split(""))
                .flatMap(s -> Arrays.stream(s))
                .toList();


        System.out.println(Arrays.toString(list1.toArray()));


    }

    //Given a list of words, count the frequency of each word using Java 8 Streams.

    private static HashMap<String, Long> frequencyOfMap(List<String> words) {

        return words.stream()
                .collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));
    }

    private static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {

        return Stream.concat(list1.stream(), list2.stream()).distinct().toList();
    }

    //  Find Duplicate Elements in a List Using Streams

    private static List<Integer> duplicateNumbers(List<Integer> numbers) {

        Set<Integer> set = new HashSet<>();

        return numbers.stream()
                .filter(n -> !set.add(n))
                .toList();
    }


    public static void main(String[] args) {
        transform();
        flattenTheList();


        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        System.out.println(frequencyOfMap(words));

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        System.out.println(mergeTwoLists(list1, list2));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 1);

        System.out.println(duplicateNumbers(numbers));
    }

}

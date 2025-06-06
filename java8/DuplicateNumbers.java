package java8;

import java.util.*;
import java.util.stream.Collectors;

//  Find Duplicate Elements in a List Using Streams
public class DuplicateNumbers {

    private static List<Integer> duplicateNumbers(List<Integer> numbers) {

        return numbers.stream()
                .collect(Collectors.groupingBy(num -> num, HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .toList();

    }


    private static List<Integer> duplicateNumbers1(List<Integer> numbers) {

        Set<Integer> set = new HashSet<>();

        return numbers.stream()
                .filter(i -> !set.add(i))
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 1);

        System.out.println(duplicateNumbers1(numbers));
    }
}

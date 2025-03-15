package java8;

//Find the first repeated element in a list.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FirstRepeatedElement {

    private static int firstRepeated(List<Integer> numbers) {

        HashSet<Integer> set = new HashSet<>();

        return numbers.stream()
                .filter(i -> !set.add(i))
                .findFirst()
                .orElse(-1);
    }


    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 3, 4, 2);

        System.out.println(firstRepeated(numbers));
    }
}

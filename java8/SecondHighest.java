package java8;

//Find the second highest number in a list.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondHighest {

    private static int secondHighest(List<Integer> numbers) {

        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .skip(numbers.stream().distinct().count() - 2)
                .findFirst()
                .orElse(-1);
    }

    private static int secondHighest2(List<Integer> numbers) {

        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);

    }


    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(5, 1, 3, 9, 7, 9, 8);
        System.out.println(secondHighest(numbers));

        System.out.println(secondHighest2(numbers));
    }
}

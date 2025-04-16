package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//Find the Second-Highest Number in a List Using Streams
public class SecondLargestNumber {

    private static int secondLargestNumber(List<Integer> numbers) {

        List<Integer> list = numbers.stream()
                .sorted((o1, o2) -> Integer.compare(o1, o2))
                .toList();

        System.out.println(list);

        return numbers.stream()
                .sorted(Integer::compare)
                .skip(numbers.size() - 2)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 10);

        System.out.println(secondLargestNumber(numbers));
    }
}

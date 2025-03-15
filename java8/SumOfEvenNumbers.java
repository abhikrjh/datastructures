package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Find the Sum of All Even Numbers in a List
public class SumOfEvenNumbers {

    private static int sumOfEveneNumbers(List<Integer> numbers) {

        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(v -> v)
                .sum();
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

        System.out.println(sumOfEveneNumbers(numbers));
    }
}

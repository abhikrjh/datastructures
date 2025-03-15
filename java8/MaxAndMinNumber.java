package java8;


//Find the maximum and minimum number in a list using Java 8 Streams.

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxAndMinNumber {


    private static void maxAndMinNumber(List<Integer> numbers){

        Integer min = numbers.stream().sorted(Comparator.naturalOrder())
                .findFirst().get();

        Integer max = numbers.stream().sorted(Comparator.reverseOrder())
                .findFirst().get();

        System.out.println("Min number is "+ min+ " , Max number is "+ max);

    }

    private static void maxAndMinNumber2(List<Integer> numbers){

        Integer max = numbers.stream()
                .max(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);

        Integer min = numbers.stream().min(Integer::compareTo)
                .orElse(Integer.MIN_VALUE);

        System.out.println("Min number is "+ min+ " , Max number is "+ max);

    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(4, 7, 1, 9, 2, 5);


        maxAndMinNumber(numbers);
        maxAndMinNumber2(numbers);
    }
}

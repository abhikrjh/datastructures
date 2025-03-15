package java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//Remove Duplicate Elements from a List
public class RemoveDuplicates {


    private static List<Integer> removeDuplicates(List<Integer> numbers){

        return numbers.stream()
                .collect(Collectors.toSet())
                .stream()
                .toList();
    }


    private static List<Integer> removeDuplicates2(List<Integer> numbers){

        return numbers.stream()
                .distinct()
                .toList();
    }

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3, 5, 6, 1);

        System.out.println(removeDuplicates(numbers));

        System.out.println(removeDuplicates2(numbers));
    }
}

package java8;

//Merge two lists and remove duplicates.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MergeTwoLists {

    private static List<Integer> mergeTwoLists(List<Integer> list1, List<Integer> list2) {

        return Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .toList();
    }

    public static void main(String[] args) {

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list2 = Arrays.asList(3, 4, 5, 6);

        System.out.println(mergeTwoLists(list1, list2));
    }
}

package java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveIt {

    //    Convert a Map to a list of keys and values separately.


    public static void main(String[] args) {

        Map<Integer, String> map = Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four",
                5, "five",
                6, "six",
                7, "seven",
                8, "eight",
                9, "nine",
                10, "ten");

        List<Map.Entry<Integer, String>> list = map.entrySet()
                .stream()
                .toList();

        System.out.println(list);

        List<String> names = Arrays.asList("java", "python", "spring");

        List<String> list1 = names.stream()
                .map(String::toUpperCase)
                .toList();
        System.out.println(list1);

        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        List<Map.Entry<String, Long>> list2 = words.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        System.out.println(list2);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 6, 3, 7, 8, 1);

        Set<Integer> set = new HashSet<>();
        List<Integer> list3 = numbers.stream()
                .filter(i -> !set.add(i))
                .toList();

        System.out.println(list3);

        List<Integer> numberss = Arrays.asList(1, 2, 3, 5, 3, 4, 2);

        int firstRepeated = numberss.stream()
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .findFirst()
                .get()
                .getKey();

        List<Map.Entry<Integer, Long>> list4 = numberss.stream()
                .collect(Collectors.groupingBy(s -> s, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();


        System.out.println(list4);
        System.out.println(firstRepeated);

        Set<Integer> set1 = new LinkedHashSet<>();
        Integer firstRepeatedNum = numberss.stream()
                .filter(i -> !set1.add(i))
                .findFirst()
                .get();
        System.out.println(firstRepeatedNum);

        List<String> wordss = Arrays.asList("apple", "banana", "cherry", "watermelon");

        String s1 = wordss.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .get();

        String s2 = wordss.stream()
                .max(Comparator.comparing(String::length))
                .get();

        System.out.println(s1);
        System.out.println(s2);

        List<Integer> nums = Arrays.asList(4, 7, 1, 9, 2, 5);

        Integer i = nums.stream()
                .max((o1, o2) -> o1.compareTo(o2))
                        .get();

        Integer i1 = nums.stream()
                .min((o1, o2) -> o1.compareTo(o2))
                .get();
        System.out.println(i1);

        List<Integer> list11 = Arrays.asList(1, 2, 3, 4);
        List<Integer> list22 = Arrays.asList(3, 4, 5, 6);

        List<Integer> list5 = Stream.concat(list11.stream(), list22.stream()).toList();

        System.out.println(list5);

        List<Integer> list6 = Stream.concat(list11.stream(), list22.stream())
                .sorted(Comparator.naturalOrder())
                .toList();

        System.out.println(list6);


        String str = "hello world";

        List<Map.Entry<Character, Long>> list7 = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        System.out.println(list7);

        List<Integer> numbs = Arrays.asList(5, 1, 3, 9, 7, 9, 8);

        Integer secondHeighest = numbs.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .get();

        System.out.println(secondHeighest);

        List<String> wordsss = Arrays.asList("apple", "banana", "kiwi", "grape");

        List<String> list8 = wordsss.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();

        System.out.println(list8);

    }


}

package java8;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

//Count occurrences/frequency of each character in a string.
public class OccuranceOfEachCharacter {


    private static void occuranceOfEachCharacter(String str) {

        List<Map.Entry<Character, Long>> list = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        System.out.println(list);
    }

    private static void occuranceOfEachCharacter2(String str) {

        Map<Character, Long> map = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        System.out.println(map);
    }


    public static void main(String[] args) {

        String str = "hello world";

        occuranceOfEachCharacter(str);
        occuranceOfEachCharacter2(str);
    }
}

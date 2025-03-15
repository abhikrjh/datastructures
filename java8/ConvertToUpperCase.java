package java8;


//Convert a List of Strings to Uppercase Using Streams

import java.util.Arrays;
import java.util.List;

public class ConvertToUpperCase {

    private static List<String> toUpperCase(List<String> names) {

        return names.stream()
                .map(s -> s.toUpperCase())
                .toList();
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("java", "python", "spring");
        List<String> upperCase = toUpperCase(names);

        System.out.println(upperCase);
    }
}

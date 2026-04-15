package java8.practice;

import java8.common.Employee;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class problems {

    public static void main(String[] args) {

        // . Print a list using Lambda Expressions .

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        names.forEach(System.out::println);

        // . Filter even numbers from a list using Streams.
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);

        List<Integer> list = numbers.stream()
                .filter(i -> i % 2 == 0)
                .toList();

        System.out.println(list);

        //. Find the maximum value in a list using Streams.

        List<Integer> nums = Arrays.asList(10, 40, 20, 70, 30, 60);

        Integer max = nums.stream().max(Integer::compareTo).get();

        System.out.println(max);

        //. Convert a list of strings to uppercase.

        List<String> list1 = Arrays.asList("ganesh", "karthik", "ashokasundari", "abhinav");

        List<String> list2 = list1.stream()
                .map(String::toUpperCase)
                .toList();

        System.out.println(list2);

        // 5. Group strings by their length using groupingBy() .
        List<String> list3 = Arrays.asList("Alice", "Bob", "Charlie");

        Map<Integer, List<String>> collect = list3.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(collect);

        //6. Find the sum of numbers using reduce() .
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4);

        Integer sum = list4.stream()
                .reduce(6, Integer::sum);

        System.out.println(sum);

        //7. Count word occurrences in a list using groupingBy() .

        List<String> words = Arrays.asList("apple", "banana", "apple");

        HashMap<String, Long> collect1 = words.stream()
                .collect(Collectors.groupingBy(s -> s, HashMap::new, Collectors.counting()));

        System.out.println(collect1);

        // 8. Concatenate strings using joining() .

        List<String> list5 = Arrays.asList("Java", "is", "awesome");

        String sentence = list5.stream()
                .collect(Collectors.joining(" "));

        System.out.println(sentence);

        //9. Sort employees by salary.

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 5000, "IT"),
                new Employee(2,"Bob", 3000,"DEV"),
                new Employee(3, "Charlie", 4000, "TEST")
        );


        List<Employee> list6 = employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();

        System.out.println(list6);

        // 10. Find the first non-repeated character in a string.

        String input = "abcdeifgabcdefgabcdefgabcdefghabcdefg";

        LinkedHashSet<Character> set = new LinkedHashSet<>();
        Character first = input.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(ch -> ch, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

        System.out.println(first);

        // 11. Remove duplicates from a list.

        List<Integer> numberss = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> list7 = numberss.stream()
                .distinct()
                .toList();

        System.out.println(list7);

        //12. Find all elements starting with "A" in a list.
        List<String> namees = Arrays.asList("Alice", "Bob", "Annie", "Alex");

        List<String> a = namees.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.startsWith("A"))
                .toList();

        System.out.println(a);

        //13. Sort a list of strings alphabetically and in reverse order.
        List<String> nammes = Arrays.asList("Charlie", "Alice", "Bob");

        List<String> list8 = nammes.stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        System.out.println(list8);

        //14. Flatten a list of lists using flatMap() .

        List<List<Integer>> nestedList = Arrays.asList( Arrays.asList(1, 2, 3), Arrays.asList(4, 5), Arrays.asList(6, 7, 8) );

        List<Integer> list9 = nestedList.stream()
                .flatMap(lists -> lists.stream())
                .toList();

        System.out.println(list9);

        //16. Find the second highest number in a list.
        List<Integer> nuumbers = Arrays.asList(10, 20, 30, 40, 50);

        Integer i = nuumbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(null);

        System.out.println(i);

        //17. Count the frequency of characters in a string using Streams.
        String str = "java";

        List<Map.Entry<Character, Long>> list10 = str.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(c -> c, HashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();

        System.out.println(list10);

        List<Map.Entry<Character, Long>> list11 = str.chars()
                .mapToObj(value -> (char) value)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet()
                .stream()
                .toList();


        System.out.println(list11);

        //18. Generate an infinite Stream of even numbers and limit it to 10 elements.

        List<Integer> list12 = Stream.iterate(0, num -> num + 2)
                .limit(10)
                .toList();

        System.out.println(list12);

        //19. Check if all elements in a list are greater than 5.

        List<Integer> numss = Arrays.asList(10, 20, 30, 40);

        boolean b = nums.stream()
                .allMatch(n -> n > 5);

        System.out.println(b);

        //20. Find the average of a list of numbers.

        List<Integer> numbs = Arrays.asList(10, 20, 30, 40);

        OptionalDouble average = numbs.stream()
                .mapToInt(Integer::valueOf)
                .average();

        System.out.println(average);

        //21.Generate the Fibonacci series using Stream.iterate() .
        // 0, 1, 1, 2, 3, 5


        // 22. Group employees by department .

        List<Employee> employeess = Arrays.asList(
                new Employee(1, "Alice", 5000, "IT"),
                new Employee(2,"Bob", 3000,"DEV"),
                new Employee(3, "Charlie", 4000, "TEST"),
                new Employee(4, "Tom", 5000, "IT"),
                new Employee(5, "Harry", 9000, "DEV"),
                new Employee(3, "Cruise", 2000, "TEST")
        );

        Map<String, List<Employee>> collect2 = employeess.stream()
                .collect(Collectors.groupingBy(Employee::getDept));


        System.out.println(collect2);

        // 23. Count occurrences of each word in a sentence.

        String strs = "Java is fun and Java is powerful";

        HashMap<String, Long> collect3 = Arrays.stream(strs.split(" "))
                .collect(Collectors.groupingBy(st -> st, HashMap::new, Collectors.counting()));

        System.out.println(collect3);

        //24. Find the longest word in a list.
        List<String> wordss = Arrays.asList("apple", "banana", "cherry", "date");

        List<String> list13 = wordss.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .toList();
        System.out.println(list13);

        String longestWord = wordss.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst()
                .orElse(null);

        System.out.println(longestWord);

        // 25. Merge two lists into a single list

        List<Integer> list14 = Arrays.asList(1, 2, 3);
        List<Integer> list15 = Arrays.asList(4, 5, 6);

        List<Integer> list16 = Stream.concat(list14.stream(), list15.stream()).toList();

        List<Integer> list17 = Stream.of(list14, list15)
                .flatMap(ls -> ls.stream())
                .toList();

        System.out.println(list16);
        System.out.println(list17);

        //26. Find the first element in a Stream greater than 10.

        List<Integer> numms = Arrays.asList(5, 8, 12, 3, 20);

        Integer i1 = numms.stream()
                .filter(n -> n > 10)
                .findFirst()
                .orElse(-1);

        System.out.println(i1);

        // 27. Find the minimum value in a list using Streams.

        List<Integer> l1 = Arrays.asList(10, 20, 5, 15);

        Integer i2 = l1.stream()
                .distinct()
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse(-1);
        System.out.println(i2);

        Integer i3 = l1.stream()
                .min((o1, o2) -> o1.compareTo(o2))
                .orElse(-1);
        System.out.println(i3);

        // 28. Use Stream.generate() to create a list of random numbers.

        //29. Find duplicate elements in a list using Streams.

        List<Integer> nuumberss = Arrays.asList(1, 2, 3, 4, 5, 2, 3);

        Set<Integer> duplicates = new HashSet<>();

        List<Integer> list18 = nuumberss.stream()
                .filter(nummss -> !duplicates.add(nummss))
                .toList();


        System.out.println(list18);

        // 35. Find all palindromic strings in a list.

        List<String> l2 = Arrays.asList("madam", "racecar", "java", "level", "hello");

        List<String> list19 = l2.stream()
                .filter(Objects::nonNull)
                .filter(s -> s.equalsIgnoreCase(new StringBuilder(s).reverse().toString()))
                .toList();

        System.out.println(list19);
    }

}

package java8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Given a list of words, count the frequency of each word using Java 8 Streams.
public class CountFrequencyOfWords {

    private static Map<String, Long> countFrequencyOfWords(List<String> words){

        words.stream()
                .collect(Collectors.groupingBy(w -> w, HashMap::new, Collectors.counting())); // This will give HashMap

        return words.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting())); // This will return map
    }


    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");

        Map<String, Long> frequencyMap = countFrequencyOfWords(words);

        System.out.println(frequencyMap);
    }
}

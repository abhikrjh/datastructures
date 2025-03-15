package java8;

//Convert a Map to a List of Keys and Values

import java.util.List;
import java.util.Map;

public class ConvertMapToAList {

    private static List<Map.Entry<Integer, String>> convert(Map<Integer, String> map){

        return map.entrySet()
                .stream()
                .toList();
    }

//    Convert a Map to a list of keys and values separately.

    private static void convert2(Map<Integer, String> map){

        List<Integer> list1 = map.keySet().stream().toList();
        List<String> list2 = map.values().stream().toList();

        System.out.println(list1);
        System.out.println(list2);
    }

    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1, "One", 2, "Two", 3, "Three");

        System.out.println(convert(map));
        convert2(map);
    }
}

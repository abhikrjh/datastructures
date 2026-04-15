package arrays;

import java.util.HashMap;
import java.util.Map;

public class EqualSumOfTwoWords {

    public static boolean isSumEqual(String firstWord, String secondWord, String targetWord) {

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> map = new HashMap();
        char[] chars = alphabet.toCharArray();

        for(int i=0; i< chars.length; i++) {
            map.put(chars[i], i);
        }

        char[] first = firstWord.toCharArray();
        StringBuilder firstSum = new StringBuilder();
        for(char c : first) {
            firstSum.append(map.get(c));
        }

        char[] second = secondWord.toCharArray();
        StringBuilder secondSum = new StringBuilder();
        for(char c : second) {
            secondSum.append(map.get(c));
        }

        char[] target = targetWord.toCharArray();
        StringBuilder targetSum = new StringBuilder();
        for(char c : target) {
            targetSum.append(map.get(c));
        }

        System.out.println(firstSum+" - "+ secondSum+" - "+ targetSum);
        return Integer.parseInt(firstSum.toString()) + Integer.parseInt(secondSum.toString()) == Integer.parseInt(targetSum.toString());
    }

    public static void main(String[] args) {

        System.out.println(isSumEqual("j", "j", "bi"));
    }
}

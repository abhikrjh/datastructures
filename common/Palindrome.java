package common;

public class Palindrome {


    private static boolean isPalindrome(String input) {

        if (input.isEmpty()) {

            return false;
        }

        return input.equals(reverse(input));
    }

    private static String reverse(String input) {

        char[] chars = input.toCharArray();

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            char temp = chars[start];

            chars[start] = chars[end];

            chars[end] = temp;

            start++;
            end--;
        }

        return String.valueOf(chars);
    }


    public static void main(String[] args) {

        String input = "level";

        System.out.println(isPalindrome(input));
    }


}

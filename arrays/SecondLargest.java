package arrays;
/*

Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit.

*/

public class SecondLargest {

    private static int secondHighest(String s) {

        int largest = -1;
        int secondLargest = -1;

        char[] chars = s.toCharArray();

        for(int i=0; i< chars.length; i++) {

            int ele = isNumeric(chars[i]);

            if(largest < ele) {

                secondLargest = largest;
                largest = ele;
            }

            if (largest > ele && secondLargest < ele) {

                secondLargest = ele;
            }

            System.out.println(ele+ " = " +secondLargest+" = "+ largest);
        }

        return secondLargest;
    }

    private static int isNumeric(char c) {

        String s = String.valueOf(c);

        int num = -1;

        try {

            num = Integer.parseInt(s);

        } catch(NumberFormatException e) {

            return -1;
        }

        return num;
    }

    public static void main(String[] args) {

        String s = "abc1111";

        int secondHighest = secondHighest(s);

        System.out.println(secondHighest);
    }
}

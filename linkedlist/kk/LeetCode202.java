package linkedlist.kk;

/*

Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay),
or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:

Input: n = 19
Output: true
Explanation:
        12 + 92 = 82
        82 + 22 = 68
        62 + 82 = 100
        12 + 02 + 02 = 1

Example 2:

Input: n = 2
Output: false
*/

import java.util.HashSet;
import java.util.Set;

public class LeetCode202 {

    public static boolean isHappy(int n) {

        Set<Integer> seenNumbers = new HashSet<>();

        while (n != 1 && !seenNumbers.contains(n)) {

            seenNumbers.add(n);
            n = getSquareSum(n);
        }

        return n == 1;
    }

    // This approach uses Floyd’s Cycle Detection Algorithm (slow & fast pointers) to detect cycles efficiently.
    // The slow pointer moves one step at a time, while the fast pointer moves two steps (applying getSquareSum twice).
    // If they meet, a cycle exists, meaning the number is not happy unless slow == 1 after the loop.
    // We check slow == 1 at the end instead of fast == 1 because fast might skip 1 due to its double-step movement.

    public static boolean isHappy2(int n) {

        int slow = n;
        int fast = n;

        do {
            slow = getSquareSum(n);
            fast = getSquareSum(getSquareSum(n));
        } while (slow != fast);

        return slow == 1;
    }

    private static int getSquareSum(int n) {

        int sum = 0;

        while (n > 0) {
            int remainder = n % 10;

            sum += remainder * remainder;

            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
        System.out.println(isHappy(2));
        System.out.println(isHappy2(19));
    }
}

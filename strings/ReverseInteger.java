package strings;
/*
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123
Output: 321

Example 2:

Input: x = -123
Output: -321

Example 3:

Input: x = 120
Output: 21
*/


public class ReverseInteger {

    private static int reverse(int num) {

//        Dividend = Divisor × Quotient + Remainder
//        123 = 10 * 12 + 3

        int x = Math.abs(num);

        int reversed = 0;

        while(x > 0){

            int quotient = x / 10;

            int remainder  = x % 10;

            // Check if reversed will overflow
            if (reversed > Integer.MAX_VALUE / 10 ||
                    (reversed == Integer.MAX_VALUE / 10 && remainder > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 ||
                    (reversed == Integer.MIN_VALUE / 10 && remainder < -8)) {
                return 0;
            }

            reversed = reversed*10 + remainder;

            x = quotient;
        }

        return num < 0 ? -reversed : reversed;
    }

    public static void main(String[] args) {

        int x = -321;

        int reverse = reverse(x);

        System.out.println(reverse);
    }
}

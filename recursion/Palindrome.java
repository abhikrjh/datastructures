package recursion;

// 14641 -> true
// 121 -> true
// 1234 -> false

public class Palindrome {

    static int reversedNumber = 0;

    static int reverse(int n) {

        int remainder = n % 10;
        int quotient = n / 10;

        reversedNumber = reversedNumber * 10 + remainder;

        if (remainder == n) {
            return reversedNumber;
        }

        return reverse(quotient);
    }

    static boolean isPalindrome(int n) {

        int reverse = reverse(n);

        System.out.println(reverse);

        return n == reverse;
    }


    public static void main(String[] args) {
        int n = 14641;

        boolean palindrome = isPalindrome(n);
        System.out.println(palindrome);
    }
}

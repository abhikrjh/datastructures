package recursion;

// 1642 -> 2461

public class ReverseANumber {

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

    public static void main(String[] args) {
        int n = 123405;

        int reverse = reverse(n);

        System.out.println(reverse);
    }

}

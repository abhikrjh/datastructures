package recursion;

public class ProductOfDigits {

    static int product(int n) {

        int remainder = n % 10;
        int quotient = n / 10;

        if (remainder == n)
            return n;

        return remainder * product(quotient);
    }

    public static void main(String[] args) {
        int n = 123456;

        int ans = product(n);

        System.out.println(ans);
    }
}

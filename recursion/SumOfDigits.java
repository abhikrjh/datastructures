package recursion;


// 12345
// 1+2+3+4+5


public class SumOfDigits {

    static int digitsSum(int n) {

        int remainder = n % 10;
        int quotient = n / 10;

        if (quotient == 0)
            return n;

        return remainder + digitsSum(quotient);
    }

    public static void main(String[] args) {
        int sum = digitsSum(12345);
        System.out.println(sum);
    }
}

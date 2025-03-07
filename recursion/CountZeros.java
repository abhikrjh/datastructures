package recursion;

// 30204 -> 2

public class CountZeros {

    static int zeroCount = 0;

    static int count(int n) {

        int remainder = n % 10;
        int quotient = n / 10;

        if (remainder == 0)
            zeroCount += 1;

        if (remainder == n)
            return zeroCount;

        return count(quotient);
    }

    public static void main(String[] args) {
        int n = 101;
        int count = count(n);

        System.out.println(count);
    }
}

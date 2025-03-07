package recursion;

// Find nth fibonacci numbers
// 0, 1, 1, 2, 3, 5, 8, 13 , ...... n
// f(n) = f(n-1) + f(n-2)

public class FibonacciNumber {


    private static int findNthFibonacciNumber(int n) {

        if (n < 2){
            return n;
        }

       return findNthFibonacciNumber(n-1) + findNthFibonacciNumber(n-2);
    }

    public static void main(String[] args) {
        int n = 3;
        int nthFibonacciNumber = findNthFibonacciNumber(n);

        System.out.println(nthFibonacciNumber);
    }
}

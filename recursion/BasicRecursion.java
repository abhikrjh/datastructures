package recursion;

public class BasicRecursion {
    static int x = 0;

    static void fun(int n) {
        if (n == 0)
            return;
        System.out.println(n);
        fun(n - 1);
    }

    static void funcReverse(int n) {
        if (n == 0)
            return;
        funcReverse(n - 1);
        System.out.println(n);
    }

    static void funcBoth(int n) {
        if (n == 0)
            return;

        System.out.println(n); // first it print this line from 1 to n

        funcBoth(n - 1);

        System.out.println(n); // when n == 0 then it will start printing this line while clearing the stack
    }

    static void fun1(int n) {

        if (n == 0)
            return;

        System.out.println(n);

//        fun1(n--);  // It will pass the value of n first to function call(func1) then subtract.
                      //  That will cause infinite loop because it will pass the same value every time
        fun1(--n);    // This will subtract the value first and then pass it to function call(func1)
    }

    public static void main(String[] args) {
        int n = 5;

        fun(n); // This will print number in reverse

        System.out.println("--------------------------");

        funcReverse(n); // This will print number from 1 to n

        System.out.println("----------------------------");

        funcBoth(n);

        System.out.println("----------------------------");

        fun1(5);
    }
}

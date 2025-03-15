package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctionalInterfaces {

    // predicate : Accepts input have some operations and returns true or false.
    private static boolean testPredicate(int num) {

        Predicate<Integer> p = i -> i % 2 == 0; // here input i
        return p.test(num);
    }

    // Consumer : Accepts input and perform some operation no return
    private static void testConsumer(int num){

        Consumer<Integer> c = i -> {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
                System.out.println();
            }
        };
        c.accept(num);
    }

    // Function : Accepts input and perform some operation and produces an output
    private static String testFunction(int num1){

        Function<Integer, String> f = a  -> { // here 1 input is a

            if(a % 2 == 0){
                return "EVEN";
            }else {
                return "ODD";
            }
        };

        return f.apply(num1);
    }

    // Supplier : supplies value without input

    private static String testSupplier(int num) {

        Supplier<String> s = () -> testFunction(num); // here no input () -> ....
        return s.get();
    }

    public static void main(String[] args) {

        /*// predicate : Accepts input have some operations and returns true or false.

        Predicate<Integer> p = num -> num % 2 == 0;

        System.out.println(p.test(3));

        // Consumer : Accepts input and perform some operation no return

        Consumer<Integer> c = num -> System.out.println(num + 4);

        c.accept(2);

        // Function : Accepts input and perform operation and produces an output

        Function<String, Integer> fun = str -> str.length();

        System.out.println(fun.apply("Abhinav"));

        // Supplier : supplies value without input

        Supplier<Double> sup = Math::random;

        System.out.println(sup.get());*/

        int num = 6;

        System.out.println(testPredicate(num));

        testConsumer(num);

        System.out.println(testFunction(num));

        System.out.println(testSupplier(num));
    }
}

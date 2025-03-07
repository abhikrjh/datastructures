package java8;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class DefaultFunctionalInterfaces {

    public static void main(String[] args) {

        // predicate : Accepts input have some operations and returns true or false.

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

        System.out.println(sup.get());
    }
}

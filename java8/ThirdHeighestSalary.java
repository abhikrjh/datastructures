package java8;

import java8.common.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


public class ThirdHeighestSalary {

    public static void main(String[] args) {


        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", 5000, "IT"),
                new Employee(2, "Bob", 7000, "Finance"),
                new Employee(3, "Charlie", 10000, "HR"),
                new Employee(4, "David", 9000, "IT"),
                new Employee(5, "Eve", 8000, "Finance"),
                new Employee(6, "Lasith", 20000, "HR")
        );


        Optional<Double> third1 = employees.stream()
                .map(employee -> employee.getSalary())
                .distinct()
                .sorted((o1, o2) -> Double.compare(o2, o1))
                .skip(2)
                .findFirst();

        Optional<Double> third2 = employees.stream()
                .map(employee -> employee.getSalary())
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst();

        Double v = employees.stream()
                .map(Employee::getSalary)
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .sorted()
                .findFirst()
                .get();

        System.out.println(third1.get());
        System.out.println(third2.get());
        System.out.println(v);


    }
}

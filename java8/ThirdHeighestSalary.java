package java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class Employee {
    int empId;
    String name;
    double salary;
    String dept;

    public Employee(int empId, String name, double salary, String dept) {
        this.empId = empId;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }
}

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


        Optional<Double> first = employees.stream()
                .map(employee -> employee.getSalary())
                .distinct()
                .sorted((o1, o2) -> Double.compare(o2, o1))
                .skip(2)
                .findFirst();

        System.out.println(first.get());


    }
}

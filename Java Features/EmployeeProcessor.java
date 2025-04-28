import java.util.*;
import java.util.stream.Collectors;
public class EmployeeProcessor {
    static class Employee {
        int id;
        String name;
        String department;
        double salary;
        Employee(int id, String name, String department, double salary)
        {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }
        public double getSalary()
        {
            return salary;
        }
        @Override
        public String toString()
        {
            return id + " - " + name + " - " + department + " - $" + salary;
        }
    }
    public static void main(String[] args)
    {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 95000),
                new Employee(2, "Bob", "Engineering", 85000),
                new Employee(3, "Charlie", "HR", 70000),
                new Employee(4, "David", "Engineering", 78000),
                new Employee(5, "Eve", "Marketing", 90000)
        );
        List<Employee> filteredSorted = employees.stream()
                .filter(e -> e.department.equalsIgnoreCase("Engineering") && e.salary > 80000)
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("Filtered and Sorted Employees:");
        filteredSorted.forEach(System.out::println);

        Map<String, Double> avgSalaryByDept = filteredSorted.stream()
                .collect(Collectors.groupingBy(
                        e -> e.department,
                        Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("\nAverage Salary per Department:");
        avgSalaryByDept.forEach((dept, avg) ->
                System.out.println(dept + ": $" + String.format("%.2f", avg)));
    }
}
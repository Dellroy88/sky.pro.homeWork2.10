package pro.sky.skypro.homeWork20.employee;


import java.util.Objects;

public class Employee {
    String firstName;
    String lastName;
    int department;
    double salary;


    public Employee(String name, String surname, int department, double salary) {
        this.firstName = name;
        this.lastName = surname;
        this.department = department;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salary == employee.salary && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }

    @Override
    public String toString() {
        return String.format("Ф.И.: %s %s", lastName, firstName);
    }
}

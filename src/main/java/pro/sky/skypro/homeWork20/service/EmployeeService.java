package pro.sky.skypro.homeWork20.service;


import org.springframework.stereotype.Service;
import pro.sky.skypro.homeWork20.employee.Employee;
import pro.sky.skypro.homeWork20.exceptions.EmployeeAlreadyAddedException;
import pro.sky.skypro.homeWork20.exceptions.EmployeeNotFoundException;
import pro.sky.skypro.homeWork20.exceptions.EmployeeStorageIsFullException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static final int LIMIT = 10;

    private final Map<String, Employee> employees = new HashMap<>();

    private final ValidatorService validatorService;

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    private String getKey(String firstName, String lastName) {
        return firstName + " " + lastName;
    }


    public Employee addEmployee(String firstName,
                                String lastName,
                                int department,
                                double salary) {
        Employee employee = validatorService.validateEmployee(firstName, lastName, department, salary);
        String key = getKey(employee.getFirstName(), employee.getLastName());
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.put(key, employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.remove(key);
    }


    public Employee findEmployee(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(key);
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees.values());
    }




}

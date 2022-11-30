package pro.sky.skypro.homeWork20.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.skypro.homeWork20.employee.Employee;
import pro.sky.skypro.homeWork20.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("lastName") String lastName,
                        @RequestParam("departmentId") int department,
                        @RequestParam double salary) {
        return employeeService.addEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("departmentId") int department,
                           @RequestParam double salary) {
        return employeeService.removeEmployee(firstName, lastName, department, salary);
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName,
                         @RequestParam("departmentId") int department,
                         @RequestParam double salary) {
        return employeeService.findEmployee(firstName, lastName, department, salary);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeService.getAll();
    }


}

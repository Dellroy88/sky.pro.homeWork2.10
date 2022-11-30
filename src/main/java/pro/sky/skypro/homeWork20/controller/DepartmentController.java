package pro.sky.skypro.homeWork20.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pro.sky.skypro.homeWork20.employee.Employee;
import pro.sky.skypro.homeWork20.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")

public class DepartmentController {

    final private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMaxSalaryFromDepartment(department);
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDepartment(@RequestParam("departmentId") int department) {
        return departmentService.findEmployeeWithMinSalaryFromDepartment(department);
    }

    @GetMapping(value = "/all", params = "/departmentId")
    public List<Employee> findEmployeesFromDepartment(@RequestParam("/departmentId") int department) {
        return departmentService.findEmployeesFromDepartment(department);
    }

    @GetMapping(value = "/all")
    public Map<Integer, List<Employee>> findEmployees() {
        return departmentService.findEmployees();
    }

}

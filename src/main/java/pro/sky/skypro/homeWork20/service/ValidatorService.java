package pro.sky.skypro.homeWork20.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.skypro.homeWork20.employee.Employee;
import pro.sky.skypro.homeWork20.exceptions.InvalidFirstNameException;
import pro.sky.skypro.homeWork20.exceptions.InvalidLastNameException;

@Service
public class ValidatorService {

    public Employee validateEmployee(String firstName,
                                     String lastName,
                                     int department,
                                     double salary) {
        if (!StringUtils.isAlpha(firstName)) {
            throw new InvalidFirstNameException();
        }
        if (!StringUtils.isAlpha(lastName)) {
            throw new InvalidLastNameException();
        }
        return new Employee(
                StringUtils.capitalize(firstName.toLowerCase()),
                StringUtils.capitalize(lastName.toLowerCase()),
                department,
                salary
        );
    }

}

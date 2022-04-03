package spring.springboot.spring_course_springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.springboot.spring_course_springboot.entity.Employee;
import spring.springboot.spring_course_springboot.service.EmployeeService;


import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) {
//            throw new NoSuchEmployeeException("is not employee with id = " + id);
//        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);

//        if (employee == null) {
//            throw new NoSuchEmployeeException("is not employee with id = " + id + " in Database.");
//        }
        employeeService.deleteEmployee(id);
        return "Employee with ID = " + id + " was deleted.";
    }


}

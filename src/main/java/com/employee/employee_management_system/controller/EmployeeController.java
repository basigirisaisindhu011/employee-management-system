package com.employee.employee_management_system.controller;

import com.employee.employee_management_system.entity.Employee;
import com.employee.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}")
    public Employee getElementById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }
    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String name){
        return employeeService.searchEmployees(name);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employeeDetails){

        return employeeService.updateEmployee(id, employeeDetails);
    }
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return "Employee deleted successfully";
    }
    @GetMapping("/page")
    public Page<Employee> getEmployees(
            @RequestParam int page,
            @RequestParam int size){
        return employeeService.getEmployees(page,size);
    }
    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted(@RequestParam String field){
        return employeeService.getEmployeesSorted(field);
    }





}

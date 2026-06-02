package com.employee.employee_management_system.service;

import com.employee.employee_management_system.entity.Employee;
import com.employee.employee_management_system.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee) {
        System.out.println("Employee ID = " + employee.getId());
        return employeeRepo.save(employee);
    }
    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }
    public List<Employee> searchEmployees(String name){
        return employeeRepo.findByNameContainingIgnoreCase(name);
    }

    public Employee getEmployeeById(Long id){
        return employeeRepo.findById(id).orElse(null);
    }
    public Employee updateEmployee(Long id, Employee employeeDetails) {

        Employee employee = employeeRepo.findById(id).orElse(null);

        if(employee != null){
            employee.setName(employeeDetails.getName());
            employee.setEmail(employeeDetails.getEmail());
            employee.setDepartment(employeeDetails.getDepartment());
            employee.setSalary(employeeDetails.getSalary());

            return employeeRepo.save(employee);
        }

        return null;
    }
    public void deleteEmployee(Long id){
        employeeRepo.deleteById(id);
    }
    public Page<Employee> getEmployees(int page,int size){
        Pageable pageable= PageRequest.of(page,size);
        return employeeRepo.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(String field){
        return employeeRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }



}
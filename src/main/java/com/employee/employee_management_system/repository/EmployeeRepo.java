package com.employee.employee_management_system.repository;

import com.employee.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    //@Override
    List<Employee> findByNameContainingIgnoreCase(String name);
}

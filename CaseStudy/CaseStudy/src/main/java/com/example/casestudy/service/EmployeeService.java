package com.example.casestudy.service;

import com.example.casestudy.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
    public Page<Employee> findAllEmployee(Pageable pageable);

//    public Page<Customer> findAllByContent(String name, Pageable pageable);

//    public Page<Customer> findAllByTopic(Long id, Pageable pageable);

    Employee getEmployeeById(Integer id);

    public Employee save(Employee employee);
}

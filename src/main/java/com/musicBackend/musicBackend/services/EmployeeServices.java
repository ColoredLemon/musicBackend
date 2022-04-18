package com.musicBackend.musicBackend.services;

import com.musicBackend.musicBackend.models.Employee;

import java.util.List;


public interface EmployeeServices {
    List<Employee> getAllEmployee();
    void save(Employee employee);
    Employee getById(Long id);
    void deleteViaId(long id);
}

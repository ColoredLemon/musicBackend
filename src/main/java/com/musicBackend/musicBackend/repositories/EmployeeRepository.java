package com.musicBackend.musicBackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musicBackend.musicBackend.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

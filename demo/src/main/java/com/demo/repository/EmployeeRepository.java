package com.demo.repository;

import com.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee , Integer> {
       Optional<Employee> findByEmailId(String email_id);
       Optional<Employee> findByMobile(String mobile);
        boolean existsByEmailId(String email_id);
}

package com.demo.repository;

import com.demo.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee , Integer> {
    Optional<Employee> findByEmailId(String email_id);
    Optional<Employee> findByMobile(String mobile);
    boolean existsByEmailId(String email_id);
    boolean existsByMobile(String mobile);
    List<Employee> findByFirstNameContaining(String keyword);
    List<Employee> findByFirstNameStartingWith(String prefix);
    List<Employee> findByFirstNameEndingWith(String suffix);
    Long countByEmailId(String _email);

    Optional<Employee>  findByEmailIdAndMobile(String _email , String _mobile);

}

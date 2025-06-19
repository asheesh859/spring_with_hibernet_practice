package com.demo.repository;

import com.demo.entity.Employee;
import org.aspectj.weaver.loadtime.Options;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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
     List<Employee> findByEmailIdOrMobile( String _email,String _mobile);

     @Query("select e from Employee e where e.emailId=:e")
     Optional<Employee> searchByEmail(@Param("e")  String _email);

     @Query("select e from Employee e where e.mobile=:m")
    Optional<Employee> searchByMobile(@Param("m") String _mobile);

     @Query("select emp from Employee emp where emp.emailId=:e and emp.mobile=:m")
     Optional<Employee> searchByEmailAndMobile(@Param("e") String _email , @Param("m") String _mobile);

     @Query(value = "Select * from employee where email_id =?1 and mobile_no =?2" , nativeQuery = true)
    Optional<Employee> seachRecordByEmailAndMobileSql(String _email , String _mobile);
}

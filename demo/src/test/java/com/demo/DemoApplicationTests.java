package com.demo;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;
	Employee emp  = new Employee();
	@Test
	void contextLoads() {
		System.out.println("Strat");
	}
	@BeforeAll
    static void test1(){
		System.out.println("Before all method in test case");
	}
	@AfterAll
    static void test2(){
		System.out.println("After all test case ");
	}
	@AfterEach
	void test3(){
		System.out.println("After each test case");
	}
	@BeforeEach
	void test4(){
		System.out.println("Before each method");
	}

	@Test
	void saveRecord(){
//		Employee emp  = new Employee();
		emp.setFirstName("suman");
		emp.setLastName("reddy");
		emp.setEmailId("sumanreddy@gmail.com");
		emp.setMobile("9808507930");
		employeeRepository.save(emp);

	}
	@Test
	void deleteRecord(){
		employeeRepository.deleteById(2);
	}
	@Test
	void updateRecordById(){
		emp.setId(1);
		emp.setFirstName("Ashu");
		emp.setLastName("prajapati");
		emp.setEmailId("pashu882@gmail.com");
		emp.setMobile("8279827373");
		employeeRepository.save(emp);
	}
@Test
	void getRecordById(){
	Optional<Employee> result = employeeRepository.findById(1);
	if(result.isPresent()){
		Employee employee = result.get();
		System.out.println(employee.getEmailId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmailId());
		System.out.println(employee.getMobile());
	}else{
		System.out.println("No record found..");
	}
}

@Test
	void findAllEmployee(){
	Iterable<Employee> allEmployee = employeeRepository.findAll();
	for(Employee emp : allEmployee){
		System.out.println(emp.getId());
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getEmailId());
		System.out.println(emp.getMobile());
	}
}

@Test
	void coutEmployee(){
	long count = employeeRepository.count();
	System.out.println(count);
}
@Test
	void findRecordByEmail(){
	Optional<Employee> result = employeeRepository.findByEmailId("pashu882@gmail.com");
	if(result.isPresent()){
		Employee emp = result.get();
		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getMobile());
		System.out.println(emp.getEmailId());


	}else {
		System.out.println("No record found");
	}
}

@Test
	void existsByEmailId(){
	boolean result = employeeRepository.existsByEmailId("pashu882@gmail.com");
	if(result){
		Optional<Employee> res =  employeeRepository.findByEmailId("pashu882@gmail.com");
		if(res.isPresent()){
			Employee emp = res.get();
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getMobile());
			System.out.println(emp.getEmailId());
		}else{
			System.out.println("No data found ..");
		}
	}
}



}

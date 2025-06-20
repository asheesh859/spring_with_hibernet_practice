package com.demo;

import com.demo.entity.Comments;
import com.demo.entity.Employee;
import com.demo.entity.Post;
import com.demo.repository.CommentRepository;
import com.demo.repository.EmployeeRepository;
import com.demo.repository.PostRepository;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.aspectj.weaver.loadtime.Options;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.SocketTimeoutException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private PostRepository postRepository;

	Employee emp  = new Employee();
	Comments comments = new Comments();
	Post post = new Post();

//	@Test
//	void contextLoads() {
//		System.out.println("Strat");
//	}
//	@BeforeAll
//    static void test1(){
//		System.out.println("Before all method in test case");
//	}
//	@AfterAll
//    static void test2(){
//		System.out.println("After all test case ");
//	}
//	@AfterEach
//	void test3(){
//		System.out.println("After each test case");
//	}
//	@BeforeEach
//	void test4(){
//		System.out.println("Before each method");
//	}

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

@Test
	void existByMobile(){
		boolean result  = employeeRepository.existsByMobile("8279827373");
		if(!result){
			System.out.println("Data not found");
		}else{
			Optional<Employee> res = employeeRepository.findByMobile("8279827373");
			if(res.isPresent()){
				Employee emp = res.get();
				System.out.println(emp.getId());
				System.out.println(emp.getFirstName());
				System.out.println(emp.getLastName());
				System.out.println(emp.getMobile());
				System.out.println(emp.getEmailId());
			}else{
				System.out.println("employee not found....");
			}

		}
}

@Test
	void findByNameContaining(){
	List<Employee> result = employeeRepository.findByFirstNameContaining("m");
	for(Employee e: result){
		System.out.println(e.getFirstName());
	}
}

@Test
	void findNameStartWith(){
		List<Employee> result = employeeRepository.findByFirstNameStartingWith("m");
		for(Employee _result : result){
			System.out.println(_result.getFirstName());
		}
}
@Test
	void findNameEndWith(){
	List<Employee> _result = employeeRepository.findByFirstNameEndingWith("u");
	for(Employee emp :_result){
		System.out.println(emp.getFirstName());
	}

}

@Test
void countRecordUsingEmail(){
		Long _count = employeeRepository.countByEmailId("pashu882@gmail.com");
		System.out.println(_count);
}

@Test
	void findRecordWithEmailAndMobile(){
		Optional<Employee> employee= employeeRepository.findByEmailIdAndMobile("pashu882@gmail.com" , "8279827373");
		if(employee.isPresent()){
			Employee emp = employee.get();

			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmailId());

		}else{
			System.out.println("No record found..");
		}
}

@Test
	void findRecordWithMobileOrEmailId(){
	List<Employee> _result;
    _result = employeeRepository.findByEmailIdOrMobile("pashu882@gmail.com","9808507960" );
    for(Employee employee : _result){
		System.out.println(employee.getId());
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getEmailId());
		System.out.println(employee.getMobile());
	}
	}
	@Test
	void searchRecordByEmail(){
		Optional<Employee> _employee;
		_employee =  employeeRepository.searchByEmail("pashu882@gmail.com");

		if(_employee.isPresent()) {
			Employee emp = _employee.get();
			System.out.println(emp.getId());
			System.out.println(emp.getFirstName());
			System.out.println(emp.getLastName());
			System.out.println(emp.getEmailId());
			System.out.println(emp.getMobile());
		}else{
			System.out.println("No data found please correct check Email..");
		}
	}

	@Test
	void searchRecordByMobile(){
	Optional<Employee> _result = employeeRepository.searchByMobile("8279827378");
		if(_result.isEmpty()){
			System.out.println("No record found please check mobile number once..");
		}else{

			Employee _employee = _result.get();
			System.out.println(_employee.getId());
			System.out.println(_employee.getFirstName());
			System.out.println(_employee.getLastName());
			System.out.println(_employee.getEmailId());
			System.out.println(_employee.getMobile());
		}

	}
	@Test
	void searchRecordByEmailAndMobile(){
		Optional<Employee> _result = employeeRepository.searchByEmailAndMobile("pashu882@gmail.com", "8279827373");
		if(_result.isEmpty()){
			System.out.println("No record found");
		}else {
			Employee _employee = _result.get();
			System.out.println(_employee.getId());
			System.out.println(_employee.getFirstName());
			System.out.println(_employee.getLastName());
			System.out.println(_employee.getEmailId());
			System.out.println(_employee.getMobile());
		}
	}
@Test
	void findRecordbyEmailAndMobileSql(){
		Optional<Employee> _result =employeeRepository.seachRecordByEmailAndMobileSql("sumanreddy@gmail.com" , "9808507930");
		if(_result.isPresent()) {
			Employee employee = _result.get();
			System.out.println(employee.getId());
			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getEmailId());
			System.out.println(employee.getMobile());

		}else{
			System.out.println("No data found check email and mobile number .. ");
		}
	}


	@Test
	void savePost(){

		Post post = new Post();
		post.setTitle("Pyton Course");
		post.setDescription("Full stack course duration 8 months");
		postRepository.save(post);

	}

	@Test
	void writeComments(){
		Post post = postRepository.findById(1).get();
		this.comments.setName("Ashu");
		this.comments.setDescription("very good");

		this.comments.setPost(post);
		this.commentRepository.save(this.comments);


	}

}


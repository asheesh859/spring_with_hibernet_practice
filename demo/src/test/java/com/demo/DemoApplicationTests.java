package com.demo;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;

@SpringBootTest
class DemoApplicationTests {

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

}

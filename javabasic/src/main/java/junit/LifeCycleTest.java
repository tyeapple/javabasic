package junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LifeCycleTest {

	public LifeCycleTest() {
		super();
		System.out.println("constructor");
	}
	
	@BeforeClass
	public static void beforeClassM() {
		System.out.println("before class");
	}
	
	@Before
	public void beforeM() {
		System.out.println("before");
	}
	
	@AfterClass
	public static void afterClassM() {
		System.out.println("after class");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Test Method 1.");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Test Method 2.");
	}
}

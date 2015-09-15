package jdk.classloader;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

import org.junit.Test;

public class ClassLoaderTest {

	@Test
	public void test1() throws ClassNotFoundException {
		Class t = Class.forName("java.lang.Thread");
		
		Method[] methods = t.getMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
	@Test
	public void test3() {
		
		ClassLoader loader = ClassLoaderTest.class.getClassLoader();
		System.out.println(loader);
		
		Integer a = 1;
		System.out.println(a.TYPE.getName());
		System.out.println(Integer.class.getName());
	}
	
	@Test
	public void test4() {
		
		System.out.println("-------------test4-------------");
		ClassLoader cl = ClassLoader.getSystemClassLoader();
		System.out.println(cl);
		while(cl != null) {
			cl = cl.getParent();
			System.out.println(cl);
		}
		
		try{
			Class<? extends Object> c = Class.forName("java.lang.Object");
			cl = c.getClassLoader();
			System.out.println("java.lang.Object's loader is " + cl);
			c = Class.forName("jdk.classloader.ClassLoaderTest");
			cl = c.getClassLoader();
			System.out.println(" ClassLoaderTest's loader is " + cl);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
 		System.out.println("-------------test4-------------");
	}
	
	@Test
	public void test5() throws MalformedURLException, ClassNotFoundException, NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException {
		
		System.out.println("-------------test5-------------");
		
		String path = System.getProperty("user.dir");
		System.out.println("user.dir="+path);
		URL[] us = {new URL("file://" + path)};
		ClassLoader loader = new URLClassLoader(us);
		Class c = loader.loadClass("jdk.classloader.ClassLoaderTest");
		Object o = c.newInstance();
		Field f = c.getField("age");
		int age = f.getInt(o);
		System.out.println("age is " + age);
		
		System.out.println("-------------test5-------------");
	}
	

	static {
		System.out.println("ClassLoaderTest is loaded");
	}
	public int age = 30;
}




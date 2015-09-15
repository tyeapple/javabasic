package j2ee.bean;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestPropertyDescriptor {

	public static void main(String[] args) throws IntrospectionException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		User user = new User();
		PropertyDescriptor descriptor = new PropertyDescriptor("name", User.class);
		Method writeMethod = descriptor.getWriteMethod();
		writeMethod.invoke(user, "lily");
		System.out.println(user);
		
		
	}

}

class User{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

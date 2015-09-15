package jdk.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Person implements Iterable<Person>{

	private String firstName;
	private String lastName;
	private int age;
	private List<Person> children = new ArrayList<Person>();
	
	public Person(String fn, String ln, int a, Person... kids) {
		this.firstName = fn;
		this.lastName = ln;
		this.age = a;
		for(Person child : kids) {
			children.add(child);
		}
	}
	public String getFirstName() { return this.firstName; }
	public String getLastName() { return this.lastName; }
	public int getAge() { return this.age; }
	public List<Person> getChildren() { return children; }
	
	public Iterator<Person> iterator() { return children.iterator(); }
	
	public void setFirstName(String value) { value = this.firstName; }
	public void setLastName(String value) { value = this.lastName; }
	public void setAge(int value) { value = this.age; }
	
	public String toString() {
		return "[Person: " +
				"firstName=" + firstName + " " +
				"lastName=" + lastName + " " +
				"age=" + age + "]";
	}
	
}

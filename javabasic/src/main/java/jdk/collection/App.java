package jdk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		Person ted = new Person("Ted", "Neward", 39, 
				new Person("Michael", "Neward", 16), 
				new Person("Matthew", "Neward", 10));
//		for(Person kid : ted) {
//			System.out.println(kid.getFirstName());
//		}
		List<Person> kids = new ArrayList<Person>(ted.getChildren());
		Collections.reverse(kids);
		System.out.println(kids);
	}
}

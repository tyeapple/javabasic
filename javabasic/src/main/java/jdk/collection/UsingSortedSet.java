package jdk.collection;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class UsingSortedSet {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("Ted", "Neward", 39),
				new Person("Ron", "Reynolds", 39),
				new Person("Charlotee", "Neward", 38),
				new Person("Matthew", "McCullough", 18)
		);
		SortedSet<Person> ss = new TreeSet<>(new Comparator<Person>() {
			public int compare(Person lhs, Person rhs) {
				return lhs.getLastName().compareTo(rhs.getLastName());
			}
		});
		ss.addAll(persons);
		System.out.println(ss);
	}
}

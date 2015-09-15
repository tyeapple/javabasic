package jdk.character;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test3 {

	
	public static void printLots(List<Integer> L, List<Integer> P) {
		
		Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		};
		Collections.sort(L, comparator);
		Collections.sort(P, comparator);
		
		for(Integer idx : P) {
			Integer value = L.get(idx-1);
			System.out.println(value);
		}
	} 
	
	public static void main(String[] args) {
		
		//Map<String, String> map = new HashMap<String, String>();
		String string = "1234";
		Integer.parseInt(string);
		
		char a = 'a';
		int _a = (char)a;
		
		System.out.println(_a);
		
		
		
		//System.out.println(_a);
		
		//System.out.println(Character.digit('4', 10));
		
		jdk.character.CharacterData.of(_a).digit(_a, 10);
		
		//printLots(Arrays.asList(9,8,7,6,5,4,3,2,1), Arrays.asList(1,3,4,6));
	}
}

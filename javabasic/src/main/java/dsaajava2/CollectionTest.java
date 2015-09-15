package dsaajava2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionTest {

	public static void main(String[] args) {
		List<Integer> lst = new ArrayList<Integer>();
		for(int i=0; i<10; i++) {
			lst.add(i);
		}
		removeEvensVer2(lst);
	}
	
	public static <AnyType> void print(Collection<AnyType> coll) {
		
		Iterator<AnyType> itr = coll.iterator();
		while(itr.hasNext()) {
			AnyType item = itr.next();
			System.out.println(item);
		}		
	}
	
	public static void removeEvensVer2(List<Integer> lst) {
		for(Integer x : lst) {
			if(x %2 == 0)
				lst.remove(x);
		}
	}
}

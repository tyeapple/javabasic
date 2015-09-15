package jsyntax;

public class CloneTest {

	public static void main(String[] args) throws Exception {
		
		Person p1 = new Person("p1", 33, new Car("Benz", 300));
		Person p2 = MyUtil.clone(p1);
		p2.getCar().setBrand("BYD");
		
		System.out.println(p1);
		System.out.println(p2);
	}
}

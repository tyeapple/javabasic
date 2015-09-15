package jsyntax;

public class InterfaceTest {

	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.getStr());
	}
}

interface IA {
	public String str = "aa";
	public String getStr();
}

class A implements IA {
	public String getStr() {
		return str;
	}
}